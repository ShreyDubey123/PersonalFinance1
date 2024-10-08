
import axios from 'axios'


axios.defaults.baseURL = 'http://192.18.100.76:8080/api';
axios.defaults.headers.post["Content-Type"] = 'application/json';
// Set default withCredentials to true
axios.defaults.withCredentials = true;


const Axios_request = (method , url, data) => {
  return axios(
    {
        method : method,
        url : url,
        data : data,
        withCredentials: true
    }
  )
}



export default Axios_request
