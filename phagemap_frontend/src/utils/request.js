import axios from 'axios'

// 每次请求携带cookies信息
axios.defaults.withCredentials = true

// create an axios instance
const service = axios.create({
  //baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  baseURL:'http://150.158.185.96:8082/api/',
  timeout: 50000, // request timeout
  async:true,
  crossDomain:true,
  headers: { 
    'Content-Type': 'application/json'
  }
})

// request interceptor
service.interceptors.request.use(
    config => {

      return config;
    },
    error => {
      return Promise.reject(error)
    }
)


// response interceptor
service.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */

    /**
     * Determine the request status by custom code
     * Here is just an example
     * You can also judge the status by HTTP Status Code
     */
    response => {
      
      // if the custom code is not 200, it is judged as an error.
      if (response.status != 200) {

        return Promise.reject(new Error(response.statusText || 'Error'))
      } else {
        return response
      }
    },
    error => {
      return Promise.reject(error)
    }

)

export default service