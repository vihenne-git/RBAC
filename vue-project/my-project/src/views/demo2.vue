<template>
    <div class="content">
      <button @click="add" class="btn">添加角色</button>
      <div class="items">
        <div class="items1">角色ID</div>
        <div class="items21">角色名</div>
        <div class="items31">角色类型</div>
        <div class="items41">角色权限</div>
      </div>
      <div v-for="item in list" v-bind:key="item.id">
        <div class="items">
          <div class="items1">{{item.id}}</div>
          <div class="items2">{{item.name}}</div>
          <div class="items3">{{item.type}}</div>
          <div class="items4">
            <div v-for="item1 in item.permission_list" v-bind:key="item1.id">
              <div class="items11">{{item1.name}}</div>
            </div>
          </div>
          <button @click="deleteRole(item.id)" class="btn">删除</button>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'demo2',
  created () {
    this.$axios.post('/user-provider/user/selectURP', {
      id: this.$root.id
    })
      .then(res => {
        // 注册成功
        this.msg = res.data
        // eslint-disable-next-line eqeqeq
        if (res.data.code == 200) {
          this.list = res.data.data.role_list
        }
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
      this.$axios.post('/role-provider/role/remove', {
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
      this.$router.push({ path: '/RoleEdit' })
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
