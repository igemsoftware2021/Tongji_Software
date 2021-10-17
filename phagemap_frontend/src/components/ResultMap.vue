<template>
  <div>
    <el-dialog
        title="Details"
        :visible.sync="dialogVisible"
        @close="dialogVisible=false;"
        width="25%"
        center
    >
      <div>
        <p>Species: {{ currentSpecies }}</p>
        <p>Name: {{ currentName }}</p>
        <p>Id: {{ currentId }}</p>
      </div>
      <div slot="footer">
        <el-button type="primary" @click="newWindow()"> View {{ currentId }} on NCBI</el-button>
        <br><br>
        <el-button @click="dialogVisible = false"> Close</el-button>
      </div>
    </el-dialog>


    <!--width,height 画布的宽度，高度。 可以是百分比或像素，一般在dom元素上设置 -->
    <div v-if="showTable" sytle="text-align : center;">
      <el-table
          ref="multipleTable"
          :data="tableData"
          tooltip-effect="dark"
          style="width: 100%"
          empty-text="No result now"
          @selection-change="handleSelectionChange"
      >
        <el-table-column
            type="selection"
        >
        </el-table-column>
        <el-table-column
            prop="bugSeqId"
            label="Super Bug Sequence Id">
        </el-table-column>
        <el-table-column
            prop="name"
            label="Super Bug Name">
        </el-table-column>
        <el-table-column
            prop="bugId"
            label="Super Bug Id">
        </el-table-column>
        <el-table-column
            prop="txid"
            label="Taxon Id"
            width="200">
        </el-table-column>
      </el-table>

      <div id="network_id" class="network" slot="reference"
        
           style="height:80vh; background: linear-gradient(to bottom, #536976, #292E49);" :span="24"
      >
      
    </div>
    <el-image 
      :src="require('@/assets/tableBlank.png')"
      v-if="!selectedItems "
      style="margin-top:-150%;width: 50%;position:relative;"></el-image>
<!--v-if="!selectedItems "-->

    </div>

    <el-row 
    
    style="background: linear-gradient(to bottom, #536976, #292E49);" v-else>
      <el-col id="network_id_2" class="network"
      v-loading="loading"
      element-loading-text="Searching..."
      element-loading-background="rgba(0, 0, 0, 0.1)"
              style="height:80vh;" :span="15">
              
            </el-col>
      <el-image 
      :src="require('@/assets/finderBlank.png')"
      v-if="responseData.length == 0 && !loading"
      style="margin-left: -130%;margin-top:20%;width: 30%;"></el-image>
      <el-col :span="9" style="background: rgba(233,236,239,0.3)">
        <!--控制栏-->
        <div style="text-align: left;height: 80vh;">
          <div 
          class="sub-title" style="line-height: 5vh;font-weight: bold;margin-left: 5%;margin-top: 3vh;">Searching
            Condition
          </div>

          <el-autocomplete
              class="input-with-select"
              style="width: 80%;margin-left: 5%;"
              v-model="searchText"
              :fetch-suggestions="querySearch"
              placeholder="Name, Seq id or Taxon id."
          >
            <el-select v-model="findCondition" slot="prepend" placeholder="Please choose">
              <el-option label="All Species" value="1"></el-option>
              <el-option label="Bacteria" value="2"></el-option>
              <el-option label="Phage" value="3"></el-option>
            </el-select>
          </el-autocomplete>

          <!--得分筛选-->
          <div class="sub-title" style="line-height: 5vh;font-weight: bold;margin-left: 5%;margin-top: 5vh;">Score</div>
          <el-input placeholder="Please input here" v-model="searchScore"
                    class="input-with-select"
                    style="width: 80%;margin-left: 5%;"
          >
            <el-select v-model="scoreCompare" slot="prepend" placeholder="Please choose">
              <el-option label="=" value="1"></el-option>
              <el-option label=">" value="2"></el-option>
              <el-option label="<" value="3"></el-option>
              <el-option label=">=" value="4"></el-option>
              <el-option label="<=" value="5"></el-option>
            </el-select>

          </el-input>

          <!--展示的结点数目-->
          <div class="sub-title" style="line-height: 5vh;font-weight: bold;margin-left: 5%;margin-top: 5vh;">Set number
            of display records
          </div>
          <el-input-number
              v-model="showNodeNumber"
              @change="handleChange"
              :min="1"
              :max="50"
              label="Node Number"
              style="margin-left: 20%;"
          ></el-input-number>

          <div style="margin-top: 5vh;margin-left: 5%;">

            <el-button
                type="primary"
                @click="clickSearch()"
                :disabled="searchText.length <= 3 || isSearching"
                plain icon="el-icon-search" round>Search
            </el-button>
            <el-button
                type="success" icon="el-icon-download"
                round @click="downloadFinderData"
                :disabled="responseData.length == 0"
            >Download
            </el-button>
          </div>

          <!--下面是介绍-->
          <div style="margin-top: 15%;margin-left: 8%;">
            <el-image :src="require('@/assets/tips.png')" style="width: 25vw;"></el-image>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import Vis from "vis";
import {findBacteriaByKey, findPhageByKey, findAllSpeciesByKey} from '@/api/finder';
import {findAllMap, findAllBug} from '@/api/map';
import {findSuggestion} from "../api/finder";

'@/api/finder';

export default {
  name: 'ResultMap',
  props: {
    showTable: Boolean
  },
  data() {

    return {
      //检索条件
      loading:false,
      selectedItems:false,
      currentSpecies: "",
      currentName: "",
      currentId: "",
      findCondition: "1",
      searchText: '',
      scoreCompare: "4",
      dialogVisible: false,
      searchScore: '0',
      showNodeNumber: 50,
      nodes: [],
      edges: [],
      // network:null,
      container: null,
      //   节点数组
      nodesArray: [],
      //   关系线数组
      edgesArray: [],
      options: {},
      data: {},
      //表格数据
      tableData: [],
      responseData: [],
      visData: [],
      expandedMAPNode: null,
      nodeMap: null,
      shownClusterId:[],
      searchSuggestion: "",
      isSearching: false
    };
  },
  created() {
    this.expandedMAPNode = new Set()
    this.nodeMap = new Map()
  },
  methods: {

    downloadFinderData() {
      console.log(this.responseData)
      if (!this.responseData.length)
        return;
      var blob = new Blob([this.responseDataToString(this.responseData)], {type: '.csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel'});
      console.log(blob);

      const url3 = window.URL.createObjectURL(blob);
      console.log(url3);
      var filename = 'searchResult' + '.csv';
      const link = document.createElement('a');
      link.style.display = 'none';
      link.href = url3;
      link.setAttribute('download', filename);
      document.body.appendChild(link);
      link.click();
    },

    responseDataToString(data) {
      if (data.length == 0) {
        return ""
      }
      var temp = "bacteriaGenebankId,bacteriaSeqNcbiId,bacteriaTaxonId,phageId,phageTaxonId,blastScore,phpScore,thirdScore,score,bacteriaName,phageScientificName\n"
      for (let j = 0; j < data.length; j++) {
        let i = data[j]
        temp += i.genebankId + ','
        temp += i.seqNcbiId + ','
        temp += i.bacteriaTxid + ','
        temp += i.phageId + ','
        temp += i.phageTxid + ','
        temp += i.blastScore + ','
        temp += i.phpScore + ','
        temp += i.score + ','
        temp += i.thirdScore + ','
        temp += i.name + ','
        temp += i.scientificName + ','
        temp += '\n'
      }
      return temp;
    },

    newWindow() {
      window.open("https://www.ncbi.nlm.nih.gov/search/all/?term=" + this.currentId);
    },

    querySearch(key, cb) {
      var path = "/all";
      if (this.findCondition === 2) path = "/bacteria";
      else if (this.findCondition === 3) path = "/phage";

      findSuggestion(path, key, 1)
      .then( response => {
        console.log(response.data);
        var result = []
        for (let i = 0; i < response.data.length; i++) {
          result.push({"value": response.data[i].name })
        }
        cb(result)
      }, error => {
        console.log(error)
      })
    },

    selectScore(score, score_limit = Number.NEGATIVE_INFINITY) {
      /*
      <el-option label="=" value="1"></el-option>
      <el-option label=">" value="2"></el-option>
      <el-option label="<" value="3"></el-option>
      <el-option label=">=" value="4"></el-option>
      <el-option label="<=" value="5"></el-option>
      */

      switch (Number(this.scoreCompare)) {
        case 1:
          return score == score_limit;
        case 2:
          return score > score_limit;
        case 3:
          return score < score_limit;
        case 4:
          return score >= score_limit;
        case 5:
          return score <= score_limit;
        default:
          return score >= score_limit;
      }
    },

    selectCondition() {
      /*
      <el-option label="All Species" value="1"></el-option>
      <el-option label="Bacteria" value="2"></el-option>
      <el-option label="Phage" value="3"></el-option>
      */
      switch (Number(this.findCondition)) {
        case 1:
          return findAllSpeciesByKey;
        case 2:
          return findBacteriaByKey;
        case 3:
          return findPhageByKey;
        default:
          return findAllSpeciesByKey
      }

    },

    initializeOptions() {
      let _this = this;
      //1.创建一个nodes数组
      _this.nodes = new Vis.DataSet(_this.nodesArray);
      //2.创建一个edges数组
      _this.edges = new Vis.DataSet(_this.edgesArray);

      if (this.showTable == true) {
        _this.container = document.getElementById("network_id");
      } else {
        _this.container = document.getElementById("network_id_2");
      }

      _this.data = {
        nodes: _this.nodes,
        edges: _this.edges
      };
      _this.options = {
        autoResize: true, //网络将自动检测其容器的大小调整，并相应地重绘自身
        locale: "cn", //语言设置：工具栏显示中文
        //设置语言
        locales: {
          cn: {
            //工具栏中文翻译
            edit: "编辑",
            del: "删除当前节点或关系",
            back: "返回",
            addNode: "添加节点",
            addEdge: "添加连线",
            editNode: "编辑节点",
            editEdge: "编辑连线",
            addDescription: "点击空白处可添加节点",
            edgeDescription: "点击某个节点拖拽连线可连接另一个节点",
            editEdgeDescription: "可拖拽连线改变关系",
            createEdgeError: "无法将边连接到集群",
            deleteClusterError: "无法删除集群.",
            editClusterError: "无法编辑群集'"
          }
        },

        // 设置节点样式
        nodes: {
          shape: "circle",
          size: 15,
          font: {
            //字体配置
            size: 15
          },
          color: {
            border: "#f1e7ea", //节点边框颜色
            background: "#97C2FC", //节点背景颜色
            highlight: {
              //节点选中时状态颜色
              border: "#f1e7ea",
              background: "#D2E5FF"
            },
            hover: {
              //节点鼠标滑过时状态颜色
              border: "#f1e7ea",
              background: "#D2E5FF"
            }
          },
          borderWidth: 3, //节点边框宽度，单位为px
          borderWidthSelected: 5 //节点被选中时边框的宽度，单位为px
        },
        // 边线配置
        edges: {
          width: 3,
          length: 300,
          color: {
            color: "#f1e7ea",
            highlight: "#f1f7fa",
            hover: "#f1f7fa",
            inherit: "from",
            opacity: 1.0
          },
          shadow: true,
          smooth: {
            //设置两个节点之前的连线的状态
            enabled: true //默认是true，设置为false之后，两个节点之前的连线始终为直线，不会出现贝塞尔曲线
          },
          arrows: {to: true} //箭头指向to
        },
        //计算节点之前斥力，进行自动排列的属性
        physics: {
          enabled: true, //默认是true，设置为false后，节点将不会自动改变，拖动谁谁动。不影响其他的节点
          barnesHut: {
            gravitationalConstant: -4000,
            centralGravity: 0.3,
            springLength: 120,
            springConstant: 0.04,
            damping: 0.09,
            avoidOverlap: 0
          }
        },
        //用于所有用户与网络的交互。处理鼠标和触摸事件以及导航按钮和弹出窗口
        interaction: {
          dragNodes: true, //是否能拖动节点
          dragView: true, //是否能拖动画布
          hover: true, //鼠标移过后加粗该节点和连接线
          multiselect: true, //按 ctrl 多选
          selectable: true, //是否可以点击选择
          selectConnectedEdges: true, //选择节点后是否显示连接线
          hoverConnectedEdges: true, //鼠标滑动节点后是否显示连接线
          zoomView: true //是否能缩放画布
        },
        //操作模块:包括 添加、删除、获取选中点、设置选中点、拖拽系列、点击等等
        manipulation: {
          enabled: false, //该属性表示可以编辑，出现编辑操作按钮
          addNode: true,
          addEdge: true,
          editEdge: true,
          deleteNode: true,
          deleteEdge: true
        },
        layout: {
          improvedLayout: false
        }
      };

      //console.log("container:",_this.container);
      //console.log("data:",_this.data);
      //console.log("options:",_this.options);

      _this.network = new Vis.Network(_this.container, _this.data, _this.options);

      _this.network.on("click", params => {
        params.event.preventDefault();
        let nodeId = _this.network.getNodeAt(params.pointer.DOM);
        if (nodeId !== undefined) {
          _this.network.selectNodes([nodeId]);
          let sNode = _this.network.getSelectedNodes()[0];
          let name = this.nodesArray[sNode].label.replace(/\n/g, ' ');

          console.log(name.substr(0, 13))
          if (name.substr(0, 13) === "Phage Cluster") {
            console.log(name[14])
            if (_this.expandedMAPNode.has(name[14])) {
              return;
            } else {
              _this.expendMAPVis(this.expendMAPVis(name.substr(14)))
              _this.expandedMAPNode.add(name.substr(14))
              // _this.initializeOptions();
            }
          }
        }
      })

      _this.network.on("oncontext", params => {
        let nodeId = _this.network.getNodeAt(params.pointer.DOM);
        if (nodeId != undefined) {
          params.event.preventDefault();
          _this.network.selectNodes([nodeId]);
          let sNode = _this.network.getSelectedNodes()[0];

          let name = this.nodesArray[sNode].label.replace(/\n/g, ' ');

          if (name.substr(0, 13) == "Phage Cluster")
            return;

          this.currentSpecies = "";
          this.currentName = "";
          this.currentId = "";

          for (let i in this.visData) {
            let item = this.visData[i];
            if (name === item.phageName) {
              this.currentSpecies = "Phage";
              this.currentName = item.phageName;
              this.currentId = item.phageId;
              break;
            }
            if (name === item.scientificName) {
              this.currentSpecies = "Phage";
              this.currentName = item.scientificName;
              this.currentId = item.phageId;
              break;

            }
            if (name === item.name) {
              this.currentSpecies = "Bacteria";
              this.currentName = item.name;
              this.currentId = item.genebankId;
              break;
            }
            if (name === item.superBugName) {
              this.currentSpecies = "Super Bug";
              this.currentName = item.superBugName;
              this.currentId = item.bugSeqId;
              break;
            }
          }

          this.dialogVisible = true;
        }
      });
    },

    init() {
      if (this.showTable == true) {
        this.requestMapDate("All Map", findAllMap, this.initializeOptions);
        this.drawMapVis(Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY);
        this.initializeOptions();
      } else {
        console.log("limit of search result:", this.showNodeNumber, this.searchScore, this.scoreCompare);
        this.requestMapDate(this.searchText, this.selectCondition(), this.initializeOptions, this.showNodeNumber, this.searchScore);
      }
    },

    resetAllNodes() {
      let _this = this;
      _this.nodes.clear();
      _this.edges.clear();
      _this.nodes.add(_this.nodesArray);
      _this.edges.add(_this.edgesArray);
      _this.data = {
        nodes: _this.nodes,
        edges: _this.edges
      };
      //   network是一种用于将包含点和线的网络和网络之间的可视化展示
      _this.network = new Vis.Network(
          _this.container,
          _this.data,
          _this.options
      );
    },
    resetAllNodesStabilize() {
      let _this = this;
      _this.resetAllNodes();
      _this.network.stabilize();
    },

    handleSelectionChange(selected) {
      //清空展出项目
      this.shownClusterId= [];
      

      console.log(selected);
      this.selectedItems = selected.length!=0;
      this.visData = [];
      for (let i in selected) {
        let bug = selected[i];

        for (let j in this.responseData) {
          let relation = this.responseData[j];

          if (relation.superBugTxid === bug.txid) {
            this.visData.push(relation);
          }
        }
      }
      this.drawMapVis(Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY);
      this.initializeOptions();
    },
    handleChange() {
      this.drawFinderVis(this.showNodeNumber, this.searchScore);
      this.initializeOptions();

    },

    drawMapVis(data_limit = 50, score_limit = Number.NEGATIVE_INFINITY) {

      let mapdata = {
        nodes: [],
        edges: [],
        nodesArray: [],
        edgesArray: [],
      };
      let genbank_set = new Set();
      let phage_set = new Set();

      data_limit = Number(data_limit);
      score_limit = Number(score_limit);


      let data_num = 0;
      for (let i in this.visData) {

        let item = this.visData[i];

        if (this.selectScore(item.score, score_limit) == false) {
          continue;
        }

        data_num = data_num + 1;
        genbank_set.add(item.superBugName);
        phage_set.add("Phage Cluster " + item.phageClusterId);

        if (data_num >= data_limit) {
          break;
        }
      }

      let genbank_map = new Map()
      let phage_map = new Map()
      let cnt = 0;
      for (let i of genbank_set) {
        genbank_map.set(i, cnt);
        cnt = cnt + 1
      }
      for (let i of phage_set) {
        phage_map.set(i, cnt);
        this.nodeMap.set(i, cnt)
        cnt = cnt + 1
      }


      for (let [k, v] of genbank_map) {
        mapdata.nodesArray.push({
          id: v, label: k.replace(/ /g, '\n'),
          color: {
            background: "#7574eb",
            highlight: "#b9b8f5",
            hover: "#b9b8f5"
          }
        })
      }

      for (let [k, v] of phage_map) {
        mapdata.nodesArray.push({
          id: v, label: k.replace(/ /g, '\n'),
          color: {
            background: '#f57797',
            highlight: "#fbc7d4",
            hover: "#fbc7d4"
          }
        })
      }

      data_num = 0;

      let record_map = new Set()

      for (let i in this.visData) {
        let item = this.visData[i];

        if (this.selectScore(item.score, score_limit) == false) {
          continue;
        }

        data_num = data_num + 1;

        let g_id = genbank_map.get(item.superBugName);
        let p_id = phage_map.get("Phage Cluster " + item.phageClusterId);
        if (record_map.has(g_id + p_id)) {
          continue;
        } else {
          record_map.add(g_id + p_id)
        }

        //console.log("score",len);
        mapdata.edgesArray.push({from: g_id, to: p_id})

        if (data_num >= data_limit) {
          break;
        }

      }
      this.edgesArray = mapdata.edgesArray;
      this.nodesArray = mapdata.nodesArray;
      this.nodes = [];
      this.edges = [];
    },

    expendMAPVis(clusterId) {
      //判断是否已经被展开
      for(let i=0;i<this.shownClusterId.length;++i){
        if(this.shownClusterId[i]==clusterId){
          return;
        }
      }

      let phage_set = new Set();

      for (let i in this.visData) {

        let item = this.visData[i];

        if (item.phageClusterId == clusterId) {
          phage_set.add(item.phageName);
        }
      }

      let phage_map = new Map()

      let cnt = this.nodes.length;
      for (let i of phage_set) {
        phage_map.set(i, cnt);
        cnt = cnt + 1
      }

      

      for (let [k, v] of phage_map) {
        this.nodes.add({
          id: v, label: k.replace(/ /g, '\n'), color: {
            background: '#f57797',
            highlight: "#fbc7d4",
            hover: "#fbc7d4"
          }
        })
        this.nodesArray.push({
          id: v, label: k.replace(/ /g, '\n'), color: {
            background: '#f57797',
            highlight: "#fbc7d4",
            hover: "#fbc7d4"
          }
        })
      }

      

      let from = this.nodeMap.get("Phage Cluster " + clusterId)
      this.shownClusterId.push(clusterId)

      for (let i in this.visData) {
        let item = this.visData[i];

        let p_id = phage_map.get(item.phageName);
        let len = item.score;

        //console.log("score",len);
        this.edges.add({from: from, to: p_id, label: len.toString()})
        this.edgesArray.push({from: from, to: p_id, label: len.toString()})

      }
      // this.edgesArray=mapdata.edgesArray;
      // this.nodesArray=mapdata.nodesArray;
      // this.nodes=[];
      // this.edges=[];
    },


    drawFinderVis(data_limit = 50, score_limit = Number.NEGATIVE_INFINITY) {

      let mapdata = {
        nodes: [],
        edges: [],
        nodesArray: [],
        edgesArray: [],
      };
      let genbank_set = new Set();
      let phage_set = new Set();

      data_limit = Number(data_limit);
      score_limit = Number(score_limit);


      let data_num = 0;
      for (let i in this.visData) {

        let item = this.visData[i];

        if (this.selectScore(item.score, score_limit) == false) {
          continue;
        }

        data_num = data_num + 1;
        genbank_set.add(item.name);
        phage_set.add(item.scientificName);

        if (data_num >= data_limit) {
          break;
        }
      }

      let genbank_map = new Map()
      let phage_map = new Map()
      let cnt = 0;
      for (let i of genbank_set) {
        genbank_map.set(i, cnt);
        cnt = cnt + 1
      }
      for (let i of phage_set) {
        phage_map.set(i, cnt);
        cnt = cnt + 1
      }


      for (let [k, v] of genbank_map) {
        mapdata.nodesArray.push({
          id: v, label: k.replace(/ /g, '\n'),
          color: {
            background: '#f57797',
            highlight: "#fbc7d4",
            hover: "#fbc7d4"
          }
        })
      }

      for (let [k, v] of phage_map) {
        mapdata.nodesArray.push({
          id: v, label: k.replace(/ /g, '\n'),
          color: {
            background: "#7574eb",
            highlight: "#b9b8f5",
            hover: "#b9b8f5"
          }
        })
      }

      data_num = 0;

      for (let i in this.visData) {
        let item = this.visData[i];

        if (this.selectScore(item.score, score_limit) == false) {
          continue;
        }

        data_num = data_num + 1;

        let g_id = genbank_map.get(item.name);
        let p_id = phage_map.get(item.scientificName);
        let len = item.score;

        //console.log("score",len);
        mapdata.edgesArray.push({from: g_id, to: p_id, label: len.toString()})

        if (data_num >= data_limit) {
          break;
        }

      }
      this.edgesArray = mapdata.edgesArray;
      this.nodesArray = mapdata.nodesArray;
      this.nodes = [];
      this.edges = [];
    },

    requestMapDate(str, find, func = () => {
                   },
                   data_limit = 50, score_limit = Number.NEGATIVE_INFINITY) {
      this.isSearching = true;
      if (this.showTable == true) {
        findAllBug().then(response => {
          this.tableData = response.data;
          this.$refs.multipleTable.toggleRowSelection([this.tableData[0]])
          this.loading = false;
        }).catch((error) => {
          //this.$message.error("There's something wrong with your network.");
          console.log("请求错误:" + error.toString());
        });
        find().then(response => {
          this.responseData = response.data;
          this.visData = [];
          this.drawMapVis(data_limit, score_limit);
          func();

        }).catch((error) => {
          //this.$message.error("There's something wrong with your network.");
          console.log("请求错误:" + error.toString());
        });
      } else {
        find(str).then(response => {
          this.isSearching = false
          this.responseData = response.data;
          this.visData = response.data;
          this.drawFinderVis(data_limit, score_limit);
          func();
          this.loading = false;
        }).catch((error) => {
          this.isSearching = false
          this.loading = false;
          //this.$message.error("There's something wrong with your network.");
          console.log("请求错误:" + error.toString());
        });
      }

    },
    //处理搜索内容
    clickSearch() {
      //加载
      this.loading = true;

      //清空上一轮的搜索结果
      this.edgesArray = [];
      this.nodesArray = [];
      this.initializeOptions();
      console.log("searching:", this.searchText);
      console.log("limit of search result:", this.showNodeNumber, this.searchScore, this.scoreCompare);
      this.requestMapDate(this.searchText, this.selectCondition(), this.initializeOptions, this.showNodeNumber, this.searchScore);

    }
  },

  mounted() {
    this.init();
  }
};
</script>
<style lang="less">

</style>

<style>
.el-select .el-input {
  width: 130px;
}
body {
    margin: 0;
  }
</style>