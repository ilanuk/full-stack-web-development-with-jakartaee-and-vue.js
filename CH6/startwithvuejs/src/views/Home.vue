<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/daniels.png">
    <HelloWorld msg="Welcome to the New Daniel's Delivery website"/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import HelloWorld from '@/components/HelloWorld.vue' // @ is an alias to /src

@Component({
  components: {
    HelloWorld
  }
})
export default class Home extends Vue {}
</script>

<style>
.home {
  text-align: center;
}
</style>
