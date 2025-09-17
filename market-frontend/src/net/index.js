import axios from 'axios';
import {ElMessage} from "element-plus";

const defaultError = () => ElMessage.error('发生了一些错误，请联系管理员')
const defaultFailure = (message) => ElMessage.warning(message)

function post(url, data, success, failure = defaultFailure, error = defaultError) {
    axios
        .post(url, data, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            withCredentials: true
        })
        .then(({ data: res }) => {
            // res 就是后端返回的整个 JSON
            if (res.success) {
                // 登录成功：后端返回的是 “data” 字段，不是 “message”
                success(res.data, res.status);
            } else {
                // 登录失败：同样用 res.data
                failure(res.data, res.status);
            }
        })
        .catch(error);
}


function get(url, success, failure = defaultFailure, error = defaultError) {
    axios
        .get(url, { withCredentials: true })
        .then(({ data: res }) => {
            if (res.success) {
                success(res.data, res.status);   // ← 用 res.data
            } else {
                failure(res.data, res.status);   // ← 用 res.data
            }
        })
        .catch(error);
}

export{
    get,
    post,
}