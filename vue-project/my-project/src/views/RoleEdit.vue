<template>
  <div class="content">
    <div class="txt">角色信息</div>
    <div>
      <div class="item">
        <div class="item_1">角色名称:</div>
        <input class="item_2" type="text" v-model="UserMessage.name" :placeholder=UserMessage.name>
      </div>
      <div class="item">
        <div class="item_1">角色类型:</div>
        <input class="item_2" type="text" v-model="UserMessage.type" :placeholder=UserMessage.type>
      </div>
    </div>
    <button class="button" @click="updateUserMessage">提交</button>
    <button class="button" @click="back">返回</button>
  </div>
</template>

<script>
export default {
  name: 'RoleEdit',
  computed: {},
  data () {
    return {
      UserMessage: {
        name: '角色名称',
        type: '类型'
      }
    }
  },
  created () {
  },
  methods: {
    updateUserMessage () {
      this.$axios.post('/role-provider/role/add', {
        name: this.UserMessage.name,
        type: this.UserMessage.type
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
