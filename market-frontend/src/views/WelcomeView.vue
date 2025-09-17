<template>
  <div style="width:100vw; height: 100vh; overflow:hidden;display: flex;">
    <div style="flex: 1;">
      <el-image src="img.jpg" mode="aspectFill" style=" width: 100%; height: 100%" fit="cover"/>
    </div>
    <div class="welcome-title">
      <div style="font-size: 30px;margin-bottom: 10px">欢迎来到我们的学习平台</div>
      <div>在这里你可以学会如何使用java，如何搭建网站，并且与java之父密切交流</div>
    </div>
    <div style="width:400px;">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "welcome"
}
</script>

<style scoped>
.welcome-title {
  user-select: none;
  position: absolute;
  bottom: 30px;
  left: 30px;
  color: white;
  font-weight: bold;
  text-shadow: 1px 1px 1px #000;
}
</style>