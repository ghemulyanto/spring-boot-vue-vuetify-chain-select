<template>
  <v-container class="fill-height" fluid>
    <v-row justify="center" align="center"
      ><v-card max-width="800" class="elevation-11 mx-auto">
        <v-card-title>
          <v-icon large left>mdi-format-list-bulleted</v-icon>
          <span class="title font-weight-light">Region</span>
        </v-card-title>
        <v-container fluid>
          <v-row align="center">
            <v-col cols="12">
              <v-autocomplete
                outlined
                dense
                label="Province"
                v-model="province"
                :items="provinces"
                item-text="name"
                item-value="id"
                item-color="primary"
                @change="loadRegencies()"
              ></v-autocomplete>
            </v-col>
            <v-col cols="12">
              <v-autocomplete
                outlined
                dense
                label="Regency"
                v-model="regency"
                :items="regencies"
                item-text="name"
                item-value="id"
                item-color="primary"
                @change="loadDistricts()"
              ></v-autocomplete>
            </v-col>
            <v-col cols="12">
              <v-autocomplete
                outlined
                dense
                label="District"
                v-model="distirct"
                :items="districts"
                item-text="name"
                item-value="id"
                item-color="primary"
                @change="loadVillages()"
              ></v-autocomplete>
            </v-col>
            <v-col cols="12">
              <v-autocomplete
                outlined
                dense
                label="Village"
                v-model="village"
                :items="villages"
                item-text="name"
                item-value="id"
                item-color="primary"
              ></v-autocomplete>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
import RegionService from "../services/region.service";
export default {
  name: "Region",

  data: () => ({
    province: null,
    provinces: [],
    regency: null,
    regencies: [],
    distirct: null,
    districts: [],
    village: null,
    villages: [],
  }),

  mounted() {
    RegionService.getProvinces().then(
      (response) => {
        this.provinces = response.data.provinces;
      },
      (error) => {
        console.log(error.message || error.response);
      }
    );
  },
  methods: {
    loadRegencies() {
      RegionService.getRegencies(this.province).then(
        (response) => {
          this.regencies = response.data.regencies;
          this.districts = [];
          this.villages = [];
        },
        (error) => {
          console.log(error.message || error.response);
        }
      );
    },
    loadDistricts() {
      RegionService.getDistricts(this.regency).then(
        (response) => {
          this.districts = response.data.districts;
          this.villages = [];
        },
        (error) => {
          console.log(error.message || error.response);
        }
      );
    },
    loadVillages() {
      RegionService.getVillages(this.distirct).then(
        (response) => {
          this.villages = response.data.villages;
        },
        (error) => {
          console.log(error.message || error.response);
        }
      );
    },
  },
};
</script>
