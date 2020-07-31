<template>
  <div class="content">
    <div class="box1"></div>
    <div class="box2">
      <input class="item_2" type="text" v-model="id" :placeholder=id>
    </div>
    <div class="box3">
      <input class="item_2" type="text" v-model="pswd" :placeholder=pswd>
    </div>
    <div class="box4">
      <div @click="regist">注册</div>
    </div>
    <div class="box5" @click="login">
      <button class="button">登录</button>
    </div>
    <div>{{msg}}</div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      pswd: '1109702845',
      id: 1
    }
  },
  methods: {
    getDate () {
      this.msg = '执行了'
      // eslint-disable-next-line no-unused-vars,no-undef
      this.$axios.get('/permission-provider/permission/list')
        .then(res => {
          this.msg = res.data
          console.log(res)
        })
        .catch(err => {
          this.msg = err
        })
    },
    login () {
      // eslint-disable-next-line no-unused-vars,no-undef
      this.$axios.post('/user-provider/user/login', {id: this.id, pswd: this.pswd})
        .then(res => {
          this.msg = res
          if (res.data.data == null) {
            this.msg = res
            // eslint-disable-next-line eqeqeq
          } else if (res.data.data == false) {
            this.msg = res
          } else {
            this.$root.id = res.data.data.id
            this.$root.pswd = res.data.data.pswd
            this.$root.nickname = res.data.data.nickname
            this.$root.email = res.data.data.email
            this.$root.create_time = res.data.data.create_time
            this.$root.last_login_time = res.data.data.last_login_time
            this.$router.push({ path: '/main' })
            this.msg = res
          }
        })
        .catch(err => {
          this.msg = err
        })
    },
    regist () {
      // 注册
      this.$router.push({ path: '/reg' })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .content{
    height: 600px;
    width: 100%;
    background: white;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  .box1{
    height: 100px;
    width: 80%;
    margin-top: 50px;
  }
  .box2{
    height: 80px;
    width: 80%;
    margin-top: 10px;
  }
  .box3{
    height: 80px;
    width: 80%;
    margin-top: 10px;
   }
  .box4{
    height: 80px;
    width: 80%;
    margin-top: 10px;
    }
  .box5{
    height: 80px;
    width: 80%;
    margin-top: 10px;
  }
  .button{
    height: 50px;
    width: 100px;
    border-radius: 20px;
    background: #42b983;
  }
  .item_2{
    height: 40px;
    width: 280px;
    font-size: 20px;
    color: #2b2f3a;
    border-radius: 20px;
  }
</style>
