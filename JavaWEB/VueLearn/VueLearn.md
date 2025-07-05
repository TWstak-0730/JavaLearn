## Vue.js 学习笔记
创建时间：2025年7月3日
---

Vue.js 是一个用于**构建用户界面**的**渐进式**JS**框架**。它的核心库专注于视图层，易于上手，并且可以与其他库或现有项目进行集成。
![Vue](Vue.png)

### 快速开始

- 准备
    - 引入Vue模块
    
    - 创建Vue实例
    
    - 创建DIV被Vue实例管理
    ```html
    <script type="module">
        import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';
        
        createApp({
            data() {
                return {
                    message: 'Hello Vue!'
                }
            }
        }).mount('#app');
    </script>
    ```
- 数据驱动视图
    - 准备数据
    - 使用`{{}}`语法绑定数据到视图

### 常用指令
HTML标签上带有`v-`前缀的属性称为**指令**。指令是Vue.js提供的特殊属性，用于在DOM元素上执行特定的操作。以下是一些常用的指令：

| 指令 | 说明 |
|------|------|
| v-if | 条件渲染 |
| v-for | 列表渲染 |
| v-bind | 动态绑定属性 |
| v-model | 双向数据绑定 |
| v-show | 切换元素显示 |
| v-on | 事件监听 |

#### v-for

- 作用: 用于渲染列表,可以遍历数组或对象。
- 语法: 
```html
<tr v-for="(item, index) in items" :key="item.id">{{item.name}}</tr>
```
- 参数说明:
  - `item`: 当前遍历的项
  - `index`: 当前项的索引
  - `items`: 要遍历的数组或对象
- `:key`: 用于优化渲染性能，确保每个元素都有唯一标识,推荐使用id作为key（唯一），使用index作为key（不唯一，会变化）。

#### v-bind
- 作用: 动态绑定元素属性
- 语法: 
```html
<img v-bind:src="imageSrc" v-bind:alt="imageAlt">
```
- 参数说明:
  - `src`: 图片的源地址
  - `alt`: 图片的替代文本

- 简写: 可以使用`:`代替`v-bind:`，例如`:src="imageSrc"`。

#### V-if/V-else/V-else-if/V-show
- 作用: 条件渲染元素
- 语法: 
```html
<div v-if="isVisible">内容可见</div>
<div v-else>内容不可见</div>
<div v-else-if="isLoading">加载中...</div>
<div v-show="isVisible">内容可见</div>
```

- 参数说明:
  - `isVisible`: 布尔值，决定是否渲染该元素
  - `isLoading`: 布尔值，决定是否显示加载状态
- 注意: `v-if`会在条件为false时完全移除元素，而`v-show`只是切换元素的显示状态。
- 适用场景:
  - `v-if`: 当需要根据条件动态添加或删除元素时使用。
  - `v-show`: 当需要频繁切换元素的显示状态时使用，性能更好。
#### v-model

- 作用: 双向数据绑定
- 语法: 
```html
<input v-model="inputValue" placeholder="请输入内容">
```
- 参数说明:
  - `inputValue`: 绑定的变量，输入框的值会自动更新到该变量中。
- 注意: `v-model`会自动处理输入事件和更新数据，适用于表单元素。

#### v-on
- 作用: 监听DOM事件
- 语法: 
```html
<button v-on:click="handleClick">点击我</button>
```
- 简写: 可以使用`@`代替`v-on:`，例如`@click="handleClick"`。
- 参数说明: 
  - `handleClick`: 绑定的事件处理函数，当按钮被点击时会调用该函数。
- 注意: `v-on`可以绑定任意DOM事件，如`click`、`mouseover`等。

### ajax

- 介绍：Asynchronous JavaScript and XML（异步JavaScript和XML），用于在不重新加载页面的情况下与服务器交换数据。
- 作用：
    - 数据交换：可以在后台与服务器进行数据交换，获取或发送数据。
    - 异步操作：允许页面在不阻塞用户操作的情况下进行数据加载和处理。

- axios
    - 介绍：对原生的Ajax进行了封装，提供了更简洁的API和更强大的功能。
    - 官网：https://axios-http.com/
    - 步骤：
        1. 引入axios库
        2. 使用axios发送请求
        3. 处理响应数据
    - 示例代码：
    ```javascript
    axios({
        method: 'get',
        url: 'https://api.example.com/data'
    })
        .then(response => { // 处理成功的响应
            console.log(response.data); 
        })
        .catch(error => { // 处理错误
            alert('Error fetching data:', error);
        });
    ```
    - 参数说明：
        - `method`: 请求方法（GET、POST等）
        - `url`: 请求的URL地址
        - `data`: 请求体数据（仅适用于POST请求）
        - `params`: URL查询参数（仅适用于GET请求）
    - 简化请求：
    ```javascript
    axios.get('https://api.example.com/data')
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            alert('Error fetching data:', error);
        });
    
    axios.post('https://api.example.com/data', { key: 'value' })
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            alert('Error posting data:', error);
        });
    ```
    - 格式
        - GET请求：`axios.get(url, { params: { key: 'value' } })`
        - POST请求：`axios.post(url, data)`

#### async/await
- 介绍：`async/await`是ES2017引入的语法糖
- 作用：使异步代码更易读，类似于同步代码的写法。
- 使用步骤：
    1. 在函数前添加`async`关键字
    2. 使用`await`关键字等待异步操作完成
- 示例代码：
```javascript
async function fetchData() {
    try {
        let response = await axios.get('https://api.example.com/data');
        console.log(response.data);
    } catch (error) {
        alert('Error fetching data:', error);
    }
}
```

### Vue生命周期
- 介绍：Vue实例在创建、更新和销毁的过程中会经历一系列
的生命周期钩子函数。
- 作用：可以在这些钩子函数中执行特定的操作，如数据初始化、事件监听等。
- 生命周期钩子函数：
| 钩子函数 | 说明 |
|----------|------|
| beforeCreate | 实例创建之前调用，此时数据观测和事件配置尚未完成。 |
| created | 实例创建完成后调用，此时数据观测和事件配置已完成
| mounted | 实例挂载到DOM上后调用，此时可以访问DOM元素。 |
| beforeUpdate | 数据更新之前调用，此时可以访问更新前的DOM状态。 |
| updated | 数据更新后调用，此时可以访问更新后的DOM状态。 |
| beforeUnmount | 实例销毁之前调用，此时可以进行清理操作。 |
| unmounted | 实例销毁后调用，此时可以进行资源释放等操作。 |

- 声明
```javascript
export default {
    data() {
        return {
            message: 'Hello Vue!'
        };
    },
    created() {
        console.log('实例创建完成');
    }
};
```
加油明天开MAVEN