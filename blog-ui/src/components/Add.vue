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
              <van-uploader v-model="uploader" />
            </template>
          </van-field>
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
      active: 1,
      name: '',
      description: '',
      uploader: [{ url: 'https://img.yzcdn.cn/vant/leaf.jpg' }]
    }
  },
  mounted: function () {},
  methods: {
    onSubmit (values) {
      console.log('submit', values)
    }
  }
}
</script>
<style>

</style>
