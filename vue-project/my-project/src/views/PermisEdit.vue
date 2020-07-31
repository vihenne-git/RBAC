<template>
  <div class="content">
    <div class="txt">权限信息</div>
    <div>
      <div class="item">
        <div class="item_1">权限名称:</div>
        <input class="item_2" type="text" v-model="UserMessage.name" :placeholder=UserMessage.name>
      </div>
      <div class="item">
        <div class="item_1">权限url:</div>
        <input class="item_2" type="text" v-model="UserMessage.url" :placeholder=UserMessage.url>
      </div>
    </div>
    <button class="button" @click="updateUserMessage">提交</button>
    <button class="button" @click="back">返回</button>
  </div>
</template>

<script>
export default {
  name: 'PermisEdit',
  computed: {},
  data () {
    return {
      UserMessage: {
        name: '权限名称',
        url: '权限url'
      }
    }
  },
  created () {
  },
  methods: {
    updateUserMessage () {
      this.$axios.post('/permission-provider/permission/add', {
        name: this.UserMessage.name,
        url: this.UserMessage.url
      })
        .then(res => {
          // 注册成功
          console.log(res)
          // eslint-disable-next-line eqeqeq
          this.$router.push({ path: '/main' })
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
