<template>
  <div id="app">
    <!--导航栏-->
    <div style="text-align: left; padding-top: 5px; padding-bottom: 5px">
      <el-button type="text"
                 style="margin-left: 5vw;font-family: 'Futura';font-weight: bold; font-size: medium"
                 @click="jumpToHomePage()">
        Phage-MAP
      </el-button>
      <span style="float: right;margin-right: 10%;">
        <el-button @click="downloadFile()" style="font-family: 'Futura'; " type="text">Docs</el-button>

        <el-button
            style="margin-left: 20px; font-family: 'Futura'; "
            type="primary"
            @click="openGitHub()" >
          Git Hub
        </el-button>
      </span>
    </div>
    <!--加一个分割线-->

    <router-view/>

<!--
ICP备案
<a href="https://beian.miit.gov.cn/#/Integrated/index" >
  <div style="display: inline-flex; padding-top: 0.5rem">
    <img :src="require('./assets/ICP.png')">
    黔ICP备2021006451号
  </div>
  </a>

-->
  </div>
</template>

<script>
export default{
  created(){
    

  },
  methods:{
    jumpToHomePage(){
      this.$router.push({path:"/"});
    },
    openGitHub(){
      window.open("https://github.com/tj-Acmen/Tongji_Software")
    },
    downloadFile(){
      //下载文件
      window.open('files/handbook-En.pdf')
    }
  }
}
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-left: 10vw;
  margin-right: 10vw;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.el-button {
  border-radius: 999em;
}

.el-button--primary {
  background: #147bfa;
}

.el-button--primary:hover {
  background: #4c4c4c;
}

</style>

<style scoped>
@import "assets/css/font.css";
</style>
