import axios from "axios";

const API_REGION_URL = "http://localhost:8080/api/";

class RegionService {
    getProvinces(){
        return axios.get(API_REGION_URL + "provinces");
    }

    getRegencies(province){
        return axios.get(API_REGION_URL + "regencies/" + province);
    }

    getDistricts(regency){
        return axios.get(API_REGION_URL + "districts/" + regency);
    }

    getVillages(district){
        return axios.get(API_REGION_URL + "villages/" + district);
    }
}
export default new RegionService();