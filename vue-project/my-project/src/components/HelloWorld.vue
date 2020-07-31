<template>
  <div class="hello">
    <div>数据： {{msg}}</div>
    <button @click="getDate">发送</button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    getDate () {
      this.msg = '执行了'
      // eslint-disable-next-line no-unused-vars,no-undef
      this.$axios.get('/permission/list')
        .then(res => {
          this.msg = res.data
          console.log(res)
        })
        .catch(err => {
          this.msg = err
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
</style>
