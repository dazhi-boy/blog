const config = require("../../config");
const app = getApp();

// pages/word/word.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    grades: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    if(null == app.globalData.openid) {
      wx.cloud.callFunction({
        name: 'login',
        data: {},
        success: res => {
          console.log('[云函数] [login] user openid: ', res.result.openid)
          app.globalData.openid = res.result.openid
          // wx.navigateTo({
          //   url: '../userConsole/userConsole',
          // })
        },
        fail: err => {
          console.error('[云函数] [login] 调用失败', err)
          wx.navigateTo({
            url: '../deployFunctions/deployFunctions',
          })
        }
      });
    }
    wx.request({
      url: config.word_grade,
      method: "GET",
      data:{},
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data.data.records)
        that.setData({
          grades: res.data.data.records
        })
      }
    })
  },
  // 进入详情页面
  _toGrade: function (event) {
    var that = this;
    // 调用接口，将openID传过去，初始化数据，开始筛选单词
    // console.log(event.currentTarget.dataset.code)
    // console.log(app.globalData.openid)
    wx.request({
      url: config.word+'/initWord/'+event.currentTarget.dataset.code+'/'+app.globalData.openid,
      method: "GET",
      data:{},
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data)
        if(200 == res.data.code){
          // 直接跳转到详情单词页
          wx.navigateTo({
            url: './grade/grade?code='+event.currentTarget.dataset.code+'&name='+event.currentTarget.dataset.name+'&openid='+app.globalData.openid
          })
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})