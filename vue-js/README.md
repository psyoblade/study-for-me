# Vue.js
> 2024.9 부터, [Vue.js](https://ko.vuejs.org/guide/introduction) 읽기 시작

## 1. 소개

### 1-1. 개념 이해

* [싱글 파일 컴포넌트](https://ko.vuejs.org/guide/scaling-up/sfc)
  * 하나의 파일에 HTML Template, CSS 및 JavaScript 모두 포함한 파일
  * `<template>` 는 vue 파일당 하나만 허용되며, javascript 에 의해 컴파일 되어 render 옵션으로 전달됩니다
  * `<script>` 는  vue 파일당 하나만 허용되며,ES Module 에 의해 실행되며, 기본 내보내기는 일반 객체 혹은 `defineComponent` 의 반환값
  * `<script setup>` 는 vue 파일당 하나만 허용되며, 전처리되어 setup() 함수로 사용됩니다
  * `<style>` 는 vue 파일당 여러개가 허용되며, scoped 나 module 속성을 가질 수 있습니다

### 1-2. 작동 방식
* Vue SFC 는 프레임워크의 파일 형식이므로, 표준 JavaScript 및 CSS 통하여 컴파일되어야 브라우저가 이해할 수 있으며,
* 컴파일된 SFC 는 표준 JavaScript(ES) 모듈입니다
* `<style>` 태그는 핫 업데이트 지원을 위해 기본 태그로 삽입되지만, 프로덕션을 위해 CSS 파일로 추출 및 병합됩니다 
* 옵션 API 방식
```javascript
<script>
export default {
  // data()에서 반환된 속성들은 반응적인 상태가 되어 `this`에 노출됩니다.
  data() { return { count: 0 } },
  // methods는 속성 값을 변경하고 업데이트 할 수 있는 함수. 템플릿 내에서 이벤트 헨들러로 바인딩 될 수 있음.
  methods: { increment() { this.count++ } },
  // 생명주기 훅(Lifecycle hooks)은 컴포넌트 생명주기의 여러 단계에서 호출됩니다. 이 함수는 컴포넌트가 마운트 된 후 호출됩니다.
  mounted() { console.log(`숫자 세기의 초기값은 ${ this.count } 입니다.`) }
}
</script>

<template>
  <button @click="increment">숫자 세기: {{ count }}</button>
</template>
```
* 컴포지션 API 방식
```javascript
<script setup>
import { ref, onMounted } from 'vue'

// 반응적인 상태의 속성
const count = ref(0)

// 속성 값을 변경하고 업데이트 할 수 있는 함수.
function increment() {
  count.value++
}

// 생명 주기 훅
onMounted(() => {
  console.log(`숫자 세기의 초기값은 ${ count.value } 입니다.`)
})
</script>

<template>
  <button @click="increment">숫자 세기: {{ count }}</button>
</template>
```

> 두 가지 스타일은 완전히 동일하게 동작하지만, 옵션 API 는 컴포지션 API 위에 구현됩니다
> Vue로 규모가 있는 앱의 전체를 구축하려는 경우 컴포지션 API + 단일파일 컴포넌트(SFC)를 사용하십시오.


## 2. [앱 생성](https://ko.vuejs.org/guide/essentials/application.html)

### 2-1. 프로젝트 생성
```shell
npm create vue@latest

cd <your-project-name>
npm install
npm run dev # 로컬 개발 서버 띄움
npn run build # 배포판 빌드
```

### 2-2. 애플리케이션 기동
* 백엔드와 프론트엔드의 구성
  * 백엔드 서버는 웹서버로 `Node.js` 로 구성하고, 프론트엔드 `SPA (Single Page Application)`으로 구성하되 `Vue.js` 프레임워크를 쓴다
* 프론트엔드 페이지 구성
```shell
/src/App.vue # 메인 Vue 애플리케이션 컴포넌트
/src/main.js # 사용하는 컴포넌트 및 플러그인을 로딩하는 Vue Application Entrypoint 이며, App.vue 를 import 한다
index.html # 웹 애플리케이션의 Web Service Entrypoint 이며, 해당 페이지에는 `main.js` 파일을 script src 하고 있다
```
* `index.html` 예제
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Vite App</title>
</head>
<body>
<div id="app"></div>
<script type="module" src="/src/main.js"></script>
</body>
</html>
```
* `src/main.js` 예제
```javascript
import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)
app.mount('#app')
```
* `src/App.vue` 예제
```javascript
<script>
import { ref } from 'vue'
const count = ref(0)
</script>

<template>
  <div id="app">
    <h1>{{ count }}</h1>
    <button @click="count++">Increase Count</button>
  </div>
</template>
```

### 2-3. 애플리케이션 구성
* 에러 핸들링, 컴포넌트 등록 및 플러그인 구성 등을 [Application API](https://ko.vuejs.org/api/application) 참고
```javascript
import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)
app.component('<components>')
app.use('<plugins>')
app.config.errorHandler = (err) => {
    console.log(err)
}
app.mount('#app')

```



## 9. Q&A

### 1. `ES 모듈` 이 뭔가?
* ES Module(ECMAScript Modules)은 JavaScript의 공식적인 모듈 시스템을 말하며 모듈화된 코드를 import, export 하는 기능을 제공한다
```javascript
// math.js
export const pi = 3.14;
export function add(x, y) {
  return x + y;
}

// app.js
import { pi, add } from './math.js';
console.log(pi); // 3.14
console.log(add(2, 3)); // 5
```

### 2. `Vue.js` 의 '옵션'이란 뭔가?
* 컴포넌트의 옵션은 컴포넌트를 정의할 때 사용되는 다양한 속성을 지칭하며, 다양한 형태의 객체(데이터, 함수, 템플릿 등)을 정의할 때 사용합니다
```javascript
export default {
  data() { // 컴포넌트 내에서 사용할 데이터를 정의
    return {
      message: "Hello, Vue!"
    };
  },
  template: `<div>{{ message }}</div>`, // 마크업을 통한 컴포넌트의 UI 정의
  methods: { // 컴포넌트에서 사용할 메서드 정의
    sayHello() {
      console.log(this.message);
    }
  },
  computed: { // 데이터를 기반으로 상태가 변할 때에 자동으로 계산되는 값을 제공
    reversedMessage() {
      return this.message.split('').reverse().join('');
    }
  },
  props: ['title'], // 부모 컴포넌트로부터 전달받는 데이터
  watch: { // 특정 데이터가 변경될 때에 수행하는 동작을 정의
    message(newVal, oldVal) {
      console.log(`Message changed from ${oldVal} to ${newVal}`);
    }
  },
  created() { // 컴포넌트의 생성, 갱신 및 소멸 시에 수행할 동작을 정의
    console.log("Component created");
  }
};
```

### 3. `<style>` 의 scoped 나 module 속성 이란?
* CSS가 특정 컴포넌트에만 적용되도록 범위를 제한하거나, 모듈화된 방식으로 CSS를 관리할 수 있다는 의미
  * scoped : 해당 컴포넌트 내부에만 적용
  * module : 모든 컴포넌트에서 충돌나지 않도록 구분자를 가지며 접근이 가능하다

### 4. 왜 SFC(Single File Component)를 사용하면 좋은가?
* 하나의 컴포넌트가 가지는 3가지 정보(template, script, style)를 모듈화 하고, 목적에 따라 구현이 가능하며, 컴파일 된 템플릿을 제공한다

### 5. 전역 빌드 (Global build) 란?
* Vue.js를 HTML 파일에서 바로 <script> 태그로 불러와 사용하는 방식입니다
```html
<script src="https://unpkg.com/vue@3"></script>
```

### 9. Vite, TypeScript 는 뭐고 어떻게 적용할 수 있는가?








## 10. 참고 사항

### 10-1. [개발자 도구](https://ko.vuejs.org/guide/scaling-up/tooling)
* [Vite](https://vitejs.dev/guide/)
* [TypeScript](https://ko.vuejs.org/guide/typescript/overview)