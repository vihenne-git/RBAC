<template>
  <div class="content">
    <div class="txt">用户信息</div>
    <div>
      <div class="item">
        <div class="item_1">ID:</div>
        <div class="item_2">{{UserMessage.id}}</div>
      </div>
      <div class="item">
        <div class="item_1">昵称:</div>
        <div class="item_2">{{UserMessage.nickname}}</div>
      </div>
      <div class="item">
        <div class="item_1">邮箱:</div>
        <div class="item_2">{{UserMessage.email}}</div>
      </div>
      <div class="item">
        <div class="item_1">创建时间:</div>
        <div class="item_2">{{UserMessage.create_time}}</div>
      </div>
      <div class="item">
        <div class="item_1">最后登录时间:</div>
        <div class="item_2">{{UserMessage.last_login_time}}</div>
      </div>
    </div>
    <button class="button" @click="updateUserMessage">修改</button>
  </div>
</template>

<script>
export default {
  name: 'demo1',
  computed: {},
  data () {
    return {
      UserMessage: {
        id: 1,
        nickname: '昵称',
        email: '邮箱',
        pswd: '密码',
        create_time: '2020/01/02',
        last_login_time: '2020/01/02'
      }
    }
  },
  created () {
    this.UserMessage.id = this.$root.id
    this.UserMessage.pswd = this.$root.pswd
    this.UserMessage.nickname = this.$root.nickname
    this.UserMessage.email = this.$root.email
    this.UserMessage.create_time = this.$root.create_time
    this.UserMessage.last_login_time = this.$root.last_login_time
  },
  methods: {
    updateUserMessage () {
      this.$router.push({ path: '/editUser' })
    }
  }
}
</script>

<style scoped>
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
    margin-bottom: 100px;
  }
</style>
