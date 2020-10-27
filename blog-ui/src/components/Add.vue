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
              <van-uploader v-model="uploader[10].uploader" :after-read="onRead"/>
            </template>
          </van-field>
          <van-field
            v-model="repData.description"
            name="description"
            label="描述"
            placeholder="描述"
            :rules="[{ required: true, message: '请填写描述' }]"
          />
          <div v-for="(item, index) in repData.detail"
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
                <van-uploader v-model="uploader[index].uploader" :after-read="onReadSub" name="index"/>
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
        <van-form @submit="onSubmit">
          <van-field
            v-model="name"
            name="主题"
            label="主题"
            placeholder="主题"
            :rules="[{ required: true, message: '请填写主题' }]"
          />
          <van-field
            v-model="description"
            name="描述"
            label="描述"
            placeholder="描述"
            :rules="[{ required: true, message: '请填写描述' }]"
          />
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
        detail: []
      },
      name: '',
      description: '',
      uploader: [
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []},
        {uploader: []}
      ],
      image: ''
    }
  },
  mounted: function () {},
  methods: {
    onSubmit (values) {
      console.log('submit', values)
      console.log(this.repData)
    },
    onRead (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      // console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.image = this.image + ',' + resp.data + ','
          this.repData.image = resp.data
          console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    onReadSub (file, detail) {
      let formData = new FormData()
      formData.append('file', file.file)
      console.log(detail)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.repData.detail[detail.index].image = resp.data
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    addSub () {
      this.repData.detail
        .push({
          name: '',
          description: '',
          image: ''
        })
      console.log('添加子主题')
    }
  }
}
</script>
<style>

</style>
