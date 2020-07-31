<template>
  <div class="content">
    <button @click="add" class="btn">添加权限</button>
    <div class="items">
      <div class="items1">权限ID</div>
      <div class="items21">权限名</div>
      <div class="items31">权限url</div>
    </div>
    <div v-for="item in list" v-bind:key="item.id">
      <div class="items">
        <div class="items1">{{item.id}}</div>
        <div class="items2">{{item.name}}</div>
        <div class="items3">{{item.url}}</div>
        <button @click="deleteRole(item.id)" class="btn">删除</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'demo3',
  created () {
    this.$axios.post('/permission-provider/permission/list', {
    })
      .then(res => {
        // 注册成功
        this.msg = res.data
        // eslint-disable-next-line eqeqeq
        this.list = res.data.data
      })
      .catch(err => {
        console.log(err)
      })
  },
  data () {
    return {
      list: [],
      msg: ''
    }
  },
  methods: {
    deleteRole (index) {
      // eslint-disable-next-line no-unused-expressions,eqeqeq
      this.$axios.post('/permission-provider/permission/remove', {
        id: index
      })
        .then(res => {
          // 注册成功
          console.log(res)
          // eslint-disable-next-line eqeqeq
          this.list.pop(index)
        })
        .catch(err => {
          console.log(err)
        })
    },
    add () {
      this.$router.push({ path: '/PermisEdit' })
    }
  }
}
</script>

<style scoped>
  .content{
    height: 100%;
    width: 100%;
    background: white;
  }
  .items{
    height: 80px;
    width: 100%;
    display: flex;
    margin-bottom: 10px;
    font-size: 10px;
    color: #3b3b3b;
  }
  .items1{
    height: 80px;
    width: 10%;
    font-size: 20px;
    color: #42b983;
  }
  .items2{
    height: 80px;
    width: 20%;
    font-size: 20px;
  }
  .items3{
    height: 80px;
    width: 10%;
    font-size: 20px;
  }
  .items4{
    height: 80px;
    width: 35%;
    display: flex;
  }
  .items11{
    margin-left: 50px;

  }
  .items21{
    height: 80px;
    width: 20%;
    font-size: 20px;
    color: #42b983;
  }
  .items31{
    height: 80px;
    width: 10%;
    font-size: 20px;
    color: #42b983;
  }
  .items41{
    height: 80px;
    width: 60%;
    font-size: 20px;
    color: #42b983;
    padding-left: 100px;

  }
  .btn{
    height: 30px;
    width: 80px;
    background: #42b983;
    color: white;
    border-radius: 20px;
  }
</style>
