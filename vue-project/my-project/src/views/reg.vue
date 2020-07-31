<template>
  <div >
    <div class="ittem">账号注册</div>
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
    <button class="button" @click="updateUserMessage">注册</button>
  </div>
</template>

<script>
export default {
  name: 'reg',
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
  methods: {
    updateUserMessage () {
      this.$axios.post('/user-provider/user/add', {
        id: this.id,
        nickname: this.nickname,
        email: this.email,
        pswd: this.pswd
      })
        .then(res => {
          // 注册成功
          console.log(res)
          // eslint-disable-next-line eqeqeq
          if (res.data.code == 200) {
            this.$Message.info('注册成功')
            this.$router.push({ path: '/main' })
          } else {
            this.$Message.info('账号创建失败')
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
  .ittem{
    margin-bottom: 20px;
  }
  .item{
    height: 40px;
    width: 340px;
    display: flex;
    flex-direction: row;
    margin-bottom: 50px;
    margin-left: 300px;
  }
  .item_1{
    margin-left: 50px;
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
