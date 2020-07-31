<template>
  <div class="content">
    <div class="txt">用户信息</div>
    <div>
      <div class="item">
        <div class="item_1">ID:</div>
        <input class="item_2" type="text" v-model="UserMessage.id" :placeholder=UserMessage.id>
      </div>
      <div class="item">
        <div class="item_1">昵称:</div>
        <input class="item_2" type="text" v-model="UserMessage.nickname" :placeholder=UserMessage.nickname>
      </div>
      <div class="item">
        <div class="item_1">邮箱:</div>
        <input class="item_2" type="text" v-model="UserMessage.email" :placeholder=UserMessage.email>
      </div>
      <div class="item">
        <div class="item_1">密码:</div>
        <input class="item_2" type="text" v-model="UserMessage.pswd" :placeholder=UserMessage.pswd>
      </div>
    </div>
    <button class="button" @click="updateUserMessage">提交</button>
    <button class="button" @click="back">返回</button>
  </div>
</template>

<script>
export default {
  name: 'dashboard',
  computed: {},
  data () {
    return {
      UserMessage: {
        id: 1,
        nickname: '昵称',
        email: '邮箱',
        pswd: '密码'
      }
    }
  },
  created () {
    this.UserMessage.id = this.$root.id
    this.UserMessage.pswd = this.$root.pswd
    this.UserMessage.nickname = this.$root.nickname
    this.UserMessage.email = this.$root.email
  },
  methods: {
    updateUserMessage () {
      this.$axios.post('/user-provider/user/edit', {
        id: this.UserMessage.id,
        nickname: this.UserMessage.nickname,
        email: this.UserMessage.email,
        pswd: this.UserMessage.pswd
      })
        .then(res => {
          // 注册成功
          console.log(res)
          // eslint-disable-next-line eqeqeq
          if (res.data.code == 200) {
            this.$router.push({ path: '/main' })
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    back () {
      this.$router.push({ path: '/main' })
    }
  }
}
</script>

<style  scoped>
  .txt{
    font-size: 30px;
    color: darkcyan;
    margin-bottom: 40px;
  }
  .content{
    height: 100%;
    width: 100%;
    background: white;
  }
  .item{
    height: 40px;
    width: 340px;
    display: flex;
    flex-direction: row;
    margin-bottom: 10px;
  }
  .item_1{
    height: 20px;
    width: 160px;
    font-size: 20px;
    color: darkcyan;
  }
  .item_2{
    height: 40px;
    width: 180px;
    font-size: 20px;
    color: #2b2f3a;
  }
  .button{
    height: 40px;
    width: 120px;
    background: darkcyan;
    color: white;
    border-radius: 20px;
  }
</style>
