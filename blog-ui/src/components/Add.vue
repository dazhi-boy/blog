<template>
  <div>
    <van-tabs v-model="active">
      <van-tab title="发起活动">
        <van-form @submit="onSubmit">
          <van-field
            v-model="repData.name"
            name="name"
            label="主题"
            placeholder="主题"
            :rules="[{ required: true, message: '请填写主题' }]"
          />
          <van-field name="uploader" label="文件上传">
            <template #input>
              <van-uploader v-model="uploader[0].uploader" :after-read="onRead"/>
            </template>
          </van-field>
          <van-field
            v-model="repData.description"
            name="description"
            label="描述"
            placeholder="描述"
            :rules="[{ required: true, message: '请填写描述' }]"
          />
          <div v-for="(item, index) in repData.details"
          v-bind:key="index">
            <van-field
              v-model="item.name"
              name="name"
              label="子主题"
              placeholder="子主题"
              :rules="[{ required: true, message: '请填写子主题' }]"
            />
            <van-field name="item.image" label="文件上传">
              <template #input>
                <van-uploader v-model="uploader[index+1].uploader" :after-read="onReadSub" :name="index"/>
              </template>
            </van-field>
            <van-field
              v-model="item.description"
              name="description"
              label="描述"
              placeholder="描述"
              :rules="[{ required: true, message: '请填写描述' }]"
            />
          </div>
          <van-button type="primary" @click="addSub">添加子主题</van-button>
          <div style="margin: 16px;">
            <van-button round block type="info" native-type="submit">
              提交
            </van-button>
          </div>
        </van-form>
      </van-tab>
      <van-tab title="创建攻略">
        <van-form @submit="onSubmitAttr">
          <van-field
            v-model="attrData.name"
            name="name"
            label="主题"
            placeholder="主题"
            :rules="[{ required: true, message: '请填写主题' }]"
          />
          <van-field name="uploader" label="文件上传">
            <template #input>
              <van-uploader v-model="uploader2[0].uploader" :after-read="onRead2"/>
            </template>
          </van-field>
          <van-field
            v-model="attrData.description"
            name="description"
            label="描述"
            placeholder="描述"
            :rules="[{ required: true, message: '请填写描述' }]"
          />
          <div v-for="(item, index) in attrData.details"
               v-bind:key="index">
            <van-field
              v-model="item.name"
              name="name"
              label="子主题"
              placeholder="子主题"
              :rules="[{ required: true, message: '请填写子主题' }]"
            />
            <van-field name="item.image" label="文件上传">
              <template #input>
                <van-uploader v-model="uploader2[index+1].uploader" :after-read="onReadSub2" :name="index"/>
              </template>
            </van-field>
            <van-field
              v-model="item.description"
              name="description"
              label="描述"
              placeholder="描述"
              :rules="[{ required: true, message: '请填写描述' }]"
            />
          </div>
          <van-button type="primary" @click="addSub2">添加子主题</van-button>
          <div style="margin: 16px;">
            <van-button round block type="info" native-type="submit">
              提交
            </van-button>
          </div>
        </van-form>
      </van-tab>
    </van-tabs>
  </div>
</template>
<script>
// import DetailAdd from "./DetailAdd";
export default {
  name: 'Add',
  data () {
    return {
      active: 0,
      repData: {
        name: '',
        description: '',
        image: '',
        details: []
      },
      attrData: {
        name: '',
        description: '',
        image: '',
        details: []
      },
      name: '',
      description: '',
      uploader: [
        {uploader: []}
      ],
      uploader2: [
        {uploader: []}
      ],
      image: ''
    }
  },
  mounted: function () {},
  methods: {
    onSubmit (values) {
      console.log(this.repData)
      this.$axios.post('/blog/activity', this.repData)
        .then(resp => {
          console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    onSubmitAttr (values) {
      console.log(this.attrData)
      this.$axios.post('/blog/attractions', this.attrData)
        .then(resp => {
          console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    onRead (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      // console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.image = this.image + ',' + resp.data + ','
          this.repData.image = resp.data
          // console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    onReadSub (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      // console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.repData.details[detail.name].image = resp.data
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    addSub () {
      this.repData.details
        .push({
          name: '',
          description: '',
          image: ''
        })
      this.uploader.push({
        uploader: []
      })
      // console.log('添加子主题')
    },
    onRead2 (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      // console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.image = this.image + ',' + resp.data + ','
          this.attrData.image = resp.data
          // console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    onReadSub2 (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      // console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.attrData.details[detail.name].image = resp.data
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    addSub2 () {
      this.attrData.details
        .push({
          name: '',
          description: '',
          image: ''
        })
      this.uploader2.push({
        uploader: []
      })
      // console.log('添加子主题')
    }
  }
}
</script>
<style>

</style>
