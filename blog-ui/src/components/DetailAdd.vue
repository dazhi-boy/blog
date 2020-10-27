<template>
    <div>
      <van-field
        v-model="name"
        name="主题"
        label="主题"
        placeholder="主题"
        :rules="[{ required: true, message: '请填写主题' }]"
      />
      <van-field name="uploader" label="文件上传">
        <template #input>
          <van-uploader v-model="uploader"/>
        </template>
      </van-field>
      <van-field
        v-model="description"
        name="描述"
        label="描述"
        placeholder="描述"
        :rules="[{ required: true, message: '请填写描述' }]"
      />
    </div>
</template>

<script>
    export default {
      name: "DetailAdd",
      data () {
        return {
          name: '',
          description: '',
          uploader: [],
          image: ''
        }
      }
    }
</script>

<style scoped>

</style>
