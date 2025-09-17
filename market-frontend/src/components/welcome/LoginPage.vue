<template>
  <div style="text-align:center; margin: 0 20px;">
    <div style="margin-top:150px">
      <div style="font-size: 25px">
        登录
      </div>
      <div style="font-size: 14px;color: darkgray">在进入系统之前请输入用户名和密码进行登录</div>
    </div>
    <div style="margin-top: 30px">
      <!-- Element Plus (Vue 3) 写法 -->
      <div class="login-form">
        <!-- 用户名输入框 -->
        <el-input
            type="text"
            placeholder="请输入用户名"
            class="input-item"
            v-model="form.username"
        >
          <template #prefix>
            <el-icon>
              <User/>
            </el-icon>  <!-- 组件式图标 -->
          </template>
        </el-input>

        <!-- 密码输入框 -->
        <el-input
            type="password"
            placeholder="请输入密码"
            class="input-item"
            v-model="form.password"
        >
          <template #prefix>
            <el-icon>
              <Lock/>
            </el-icon>
          </template>
        </el-input>
      </div>
      <el-row>
        <el-col :span="12" style="text-align:left;margin-top:5px">
          <el-checkbox v-model="form.remember" label="记住我" size="large"></el-checkbox>
        </el-col>
        <el-col :span="12" style="text-align:right;margin-top:10px">
          <el-link>忘记密码？</el-link>
        </el-col>
      </el-row>
      <div style="margin:30px 0">
        <el-button @click="login" style=" width: 270px" type="success" plain>登录</el-button>
      </div>
      <el-divider>
        <span style="color:gray">没有账号？</span>
      </el-divider>
      <div>
        <el-button style=" width: 270px" type="warning" plain>注册</el-button>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import {post} from "@/net";
import {reactive} from 'vue';
import {ElMessage} from "element-plus";
import router from "@/router";

const form = reactive({
  username: '',
  password: '',
  remember: false,
})

// 登录函数，处理用户登录逻辑
const login = () => {
  // 验证用户名和密码是否为空
  if (!form.username || !form.password) {
    // 如果有任何一个为空，显示警告提示
    ElMessage.error("请填写用户名和密码")
  } else {
    // 用户名和密码都不为空时，调用登录接口
    post(
        '/api/auth/login',
        {
          username: form.username,
          password: form.password,
          remember: form.remember
        },
        message => {
          ElMessage.success(message);   // 这里 message 就是 res.data
          router.push('/index');
        }
    );
  }
}
</script>
<style scoped>
.input-item {
  margin: 10px 0;
  width: 100%;
  height: 50px;
}
</style>