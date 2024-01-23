<template>
  <Interface/>
</template>

<script>
import Interface from './components/Interface.vue'

export default {
  name: 'App',
  components: {
    Interface
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color:rgb(248, 248, 248);
  margin: 0px;
  padding: 0px;
  min-width: 800px;
  max-height: 100%;
}
</style>
