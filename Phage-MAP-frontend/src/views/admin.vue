<template>
    <div>
        <div v-if="!hasLogin">
            <div class="login">
                <el-container>
                  <el-header></el-header>
                  <div style="height: 40px"></div>
                  <el-main>
                    <el-card class="box-card">
                      <div style="height: 20px"></div>
                      <div style="margin-bottom: 30px; font-weight: bold">管理员登录</div>
                      <el-form label-width="60px">
                        <el-form-item label="用户名">
                          <el-input v-model="username"></el-input>
                        </el-form-item>
                        <el-form-item label="密码">
                          <el-input v-model="password" show-password></el-input>
                        </el-form-item>
                      </el-form>
                      <div style="height: 10px"></div>
                      <el-button
                        type="primary"
                        round
                        style="width: 35%; margin-bottom: 10px"
                        @click="clilogin"
                        >登录</el-button
                      >
                    </el-card>
                    <div style="height: 168px"></div>
                  </el-main>
                </el-container>
              </div>
        </div>
        <div v-if="hasLogin">
            <el-row>
                <el-col :span="5">
                    <el-menu :default-active="selectItem" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                        <el-menu-item index="1">
                            <i class="el-icon-s-comment"></i>
                            <span slot="title">评论管理</span>
                        </el-menu-item>
                        <el-menu-item index="2" disabled>
                            <i class="el-icon-document"></i>
                            <span slot="title">待开发</span>
                        </el-menu-item>
                        <el-menu-item index="3" disabled>
                            <i class="el-icon-setting"></i>
                            <span slot="title">待开发</span>
                        </el-menu-item>
                    </el-menu>
                </el-col>
                <el-col :span="19">
                    <!--工具栏-->
                    <div v-if="selectItem==='1'">
                        <div>
                            <div  v-for="(comment, index) in
                                (publishedCurrentPage!=commentNum/5?
                                comments.slice(5*publishedCurrentPage-5,5*publishedCurrentPage):
                                comments.slice(5*publishedCurrentPage-5,commentNum)
                                )" :key="index">
                                <el-card class="box-card" style="width: 800px;height: 100%;margin:0 auto">
                                    <span class="bigFontSize" style="font-size: 15px;float: left;color: #7b7b7b">
                                        <i class="el-icon-time"></i>
                                        Time：{{comment.time}}</span>
                                    <span style="float: right;">
                                        <el-button type="danger" icon="el-icon-delete"
                                        @click="deleteSelectedComment(index)" 
                                        circle></el-button></span>
                                    <br><br>
                        
                                    <span class="NameFontSize" style="font-size: 20px;float:left;padding-left: 2%">
                                        {{comment.firstname}}&nbsp;&nbsp;
                                        {{comment.lastname}}</span>
                                    <el-divider></el-divider>
                                    <span class="commentSize" style="font-family: 'goodFont';">
                                        {{comment.content}}</span>
                                    <br>
                                
                                </el-card>
                                <br>
                            </div>
                        
                            <el-pagination v-if="commentNum>=4" layout="prev, pager, next" :page-size="5" :total="commentNum"
                                @current-change="current_change" style="float: bottom ;padding-bottom: 1%" background>
                        
                        
                            </el-pagination>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>

</template>

<script>
import { getComment,deleteComment } from '@/api/board';
Array.prototype.remove = function(from, to) {
  var rest = this.slice((to || from) + 1 || this.length);
  this.length = from < 0 ? this.length + from : from;
  return this.push.apply(this, rest);
};
export default{

    name:'admin',
    data(){
        return{
            hasLogin:false,
            username:'',
            password:'',
            selectItem:'1',
            comments:[],
            commentNum:0,
            publishedCurrentPage:1
        }
    },
    created(){
        getComment().then(response=>{
            this.comments=eval(response.data).reverse();
            //按时间倒序排列
            this.commentNum=this.comments.length
            this.couponList=response.data.couponList; 
            console.log(this.comments)
        }).catch(()=>{
            this.$message.error("There's something wrong with your network.");
        })


    },
    methods:{
        //删除评论
        deleteSelectedComment(id){
            console.log(id)
            //弹出确认框
            this.$confirm('确认删除此评论吗？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                deleteComment(this.comments[id].id).then(response=>{
                    response
                    
                    //从comments中删除下标为id
                    this.comments.remove(id,id+1)
                    //调api
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });

                }).catch(()=>{
                    this.$message.error("网络异常");
                })

            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });          
            });
        },
        clilogin(){
            if(this.username!='root' || this.password!='tongjiigem2021'){
                this.$message({
                    message: '错误的账号或密码',
                    type: 'warning'
                });
                return;
            }
            //成功登录
            this.$message({
                message: '成功登陆！',
                type: 'success'
            });
            this.hasLogin=true;
        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        current_change(publishedCurrentPage){
            this.publishedCurrentPage=publishedCurrentPage
        },
    }
}
</script>

<style scoped>
    body {
      margin: 0px;
    }
    .login {
      background-image: url(https://oliver-img.oss-cn-shanghai.aliyuncs.com/img/b190fa0e5850486d.jpg);
      background-size: cover;
      width: 100%;
      height: 100%;
      background-repeat: no-repeat;
      background-size: 100% 100%;
      text-align: center;
      margin: 0 auto;
    }
    .text {
      font-size: 14px;
    }
    .item {
      padding: 18px 0;
    }
    .box-card {
      width: 350px;
      height: 300px;
      margin: 0 auto;
    }
    .el-button {
      margin: 0 auto;
      text-align: center;
    }
    </style>