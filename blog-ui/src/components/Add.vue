<template>
  <div>
    <van-tabs v-model="active">
      <van-tab title="发起活动">
        <van-form @submit="onSubmit">
          <van-field
            v-model="name"
            name="主题"
            label="主题"
            placeholder="主题"
            :rules="[{ required: true, message: '请填写主题' }]"
          />
          <van-field name="uploader" label="文件上传">
            <template #input>
              <van-uploader v-model="uploader" :after-read="onRead"/>
            </template>
          </van-field>
          <van-field
            v-model="description"
            name="描述"
            label="描述"
            placeholder="描述"
            :rules="[{ required: true, message: '请填写描述' }]"
          />
          <van-button type="primary" @click="addSub()">添加子主题</van-button>
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
export default {
  name: 'Add',
  data () {
    return {
      active: 0,
      name: '',
      description: '',
      uploader: [],
      image: ''
    }
  },
  mounted: function () {},
  methods: {
    onSubmit (values) {
      console.log('submit', values)
    },
    onRead (file) {
      let formData = new FormData()
      formData.append('file', file.file)
      console.log(formData)
      this.$axios.post('/upload', formData)
        .then(resp => {
          this.image = this.image + ',' + resp.data + ','
          console.log(resp.data)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    addSub () {
      console.log('添加子主题')
    }
  }
}
</script>
<style>

</style>
