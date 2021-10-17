<template>
<div class="home" ref="home">
    <div style="margin-top: 5vh;">
    <el-container>
        <el-aside style="width: 40vw;margin-left: 10vw;text-align: left;">
        <div style="margin-top: 5vh;width: 80%;">
            <p style="font-size: large;">We have bulit a database</p>
            <div style="margin-top: 10px;">
            <b style="color: #409EFF;
            font-size: xx-large;font-family: 'FZHeiBJW'"> Bacteriophage Bay</b>
            </div>
            <p style="font-size: medium;color: grey;">
              We put data in a well-organised database. <br>
              By clicking, you can download it.
            </p>
        </div>
        <!--空白部分-->
        <div style="margin-top: 10%;">
            <el-button type="primary" style="border-radius: 10px;">Download</el-button>
            
        </div>
        </el-aside>
        <el-main style="text-align: left;">
        <!--图片-->
        <el-image :src="require('@/assets/bayImg.png')"></el-image>
        </el-main>
    </el-container>
    </div>


    <div style="margin-top:5%;background-color: #f9faff;height: 5%;">&nbsp;&nbsp;</div>

    <div>
    <el-container style="margin-top: 5vh;width: 90%;margin-left: 5%;">    
        <el-aside style="width: 60%;text-align: left;">
        <div style="margin-top: 10vh;overflow: hidden;">
            <!--两行三列-->
            <el-row :gutter="24" >
            <el-col :span="8" v-for="(item,i) in introduction" :key="i">
                <div class="grid-content bg-purple" style="margin-bottom: 3vh;
                background-image: url('https://z3.ax1x.com/2021/09/05/hWAd7F.png');
                background-repeat: no-repeat;
                background-position: 25% 0%;
                background-size: 50% 20%;">
                <i class="el-icon-bell">Highlight{{i+1}}</i>
                <br>
                <b>{{item.title}}</b>
                <p>{{item.description}}</p>
                </div>
            </el-col>
            </el-row>

        </div>
        </el-aside>
        <el-main>
        <div>
            <el-image :src="require('@/assets/3.png')"></el-image>
        </div>
        </el-main>
    </el-container>
    </div>


    <div style="background-color: #f9faff;height: 5%;">&nbsp;&nbsp;</div>

    <!--联系-->
    <div style="font-family: 'goodFont';background-color: #40a0ff86;width: 80%;margin-left: 10%;border-radius: 30px;">
    <div style="margin-top: 5vh;">
        <br><br>
        <b style="font-size: xx-large;">CONTACTS</b>
        <p style="color: white;">If you have any feedback, please contact us</p>
        <b>EMAIL</b>
        <p style="color: white;">tj_software2021@163.com</p>
        <b>ADDRESS</b>
        <p style="color: white;">Tongji University, No.1239 siping Road, Yangpu District, Shanghai</p>
        <br>
    </div>
    </div>


</div>


</template>

<script>

export default {
    name: 'Bay',
    mounted(){
        this.$refs["home"].scrollIntoView(true);
    },
    data(){
        return{
            introduction:[
        {
          //highlight:'强调',
          title:'题目1',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },
        {
          //highlight:'强调',
          title:'题目2',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },{
          //highlight:'强调',
          title:'题目3',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },{
          //highlight:'强调',
          title:'题目4',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },{
          //highlight:'强调',
          title:'题目5',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },{
          //highlight:'强调',
          title:'题目6',
          description:'我是一段很有意思的描述符，你不要觉得我没有意思，呵呵呵呵呵'
        },
      ],
        }
    }
}

</script>

<style scoped>
/*#ratings{*/
/*  display: block;*/

/*}*/
.el-icon-star-on:before {
    font-size: 1.5em !important;
}
.bigFontSize{
    font-size: 10px;
    color: #999;
    padding:6px 6px;
    font-family:"FZHeiBJW","Lato-Bold";
    margin:1px;
    word-wrap: break-word;
    word-break: normal;
}
.NameFontSize{
    font-size:22px;
    padding: 1px 6px;
    font-weight: bold;
    text-align: left;
    display:block;
    margin-top:10px;
    margin-right:10px;
    font-family:"Lato-Bold","FZHeiBJW";
    flex: 1;  
}
.commentSize{
    font-size: 18px;
    color: rgb(2, 0, 0);
    padding:6px 6px;
    display: block;
    font-family:"PingFang SC";
    margin:1px;
    text-align: left;
    word-wrap: break-word;
    word-break: normal;
}
#ratings{
    
    vertical-align: middle;
    padding-left: 12px;
    text-align: center;
    font-family:"Lato-Bold";
    /*width: 20px;*/
    /*background-color: blue;*/
}

#commentNumText{
    display:inline-block;
    font-size: 1.2em;
    /*horiz-align: center;*/
}

#myIcon{
    display:inline-block;
    margin-right:10px;
    color:#0f68ba;
    font-size:1.2em;
}

.outer-box-card{
    border-radius: 15px;
    border-width: 3px;
    border-color: #7b7b7b;
    background-color: #ffffff;
    box-shadow: 7px 7px 10px #888888;
    animation: fadeInDown;
    animation-duration: 0.5s;
}
</style>