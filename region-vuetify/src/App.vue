<template>
  <v-app>
    <v-app-bar app color="primary" dark dense> </v-app-bar>

    <v-main>
      <Region />
    </v-main>
  </v-app>
</template>

<script>
import Region from "./components/Region";

export default {
  name: "App",

  components: {
    Region,
  },

  data: () => ({
    //
  }),
};
</script>
