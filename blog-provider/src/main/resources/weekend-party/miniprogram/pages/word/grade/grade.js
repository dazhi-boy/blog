// pages/word/grade/grade.js
const config = require("../../../config");
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    code: '',
    name: '',
    openid: '',
    data: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      code: options.code,
      name: options.name,
      openid: options.openid
    });
    var that = this;
    wx.request({
      url: config.word + 'count' + '/' + options.code + '/' + options.openid,
      method: "GET",
      data: {},
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data.data)
        that.setData({
          data: res.data.data
        })
      }
    })
  },

  exclude: function(event) {
    wx.navigateTo({
      url: '../exclude/exclude?code='+event.currentTarget.dataset.code+'&openid='+app.globalData.openid
    })
  },

  remember: function(event) {
    wx.request({
      url: config.word + 'initTree',
      method: "POST",
      data: {
        grade: event.currentTarget.dataset.code,
        userId: app.globalData.openid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data.data)
      }
    })
    wx.navigateTo({
      url: '../memory/memory?code='+event.currentTarget.dataset.code+'&openid='+app.globalData.openid
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
    var self = this;
    wx.showToast({
        title:'加载中....',
        icon:'loading'
    });
    setTimeout(() => {
      wx.request({
        url: config.word + 'count' + '/' + self.data.code + '/' + self.data.openid,
        method: "GET",
        data: {},
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
          console.log(res.data.data)
          self.setData({
            data: res.data.data
          })
        }
      })
      // 数据成功后，停止下拉刷新
      wx.stopPullDownRefresh();
    }, 1000);
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