// pages/word/memory/memory.js
const config = require("../../../config");
let loop = false;

let innerAudioContext = null;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    word: {},
    index: 0,
    code: '',
    basePath: '',
    showView: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    loop = false;
    innerAudioContext = wx.createInnerAudioContext();
    innerAudioContext.autoplay = true;
    innerAudioContext.onPlay(()=>{//监听播放事件
    })
    innerAudioContext.onStop(()=>{//监听停止事件
    })
    innerAudioContext.onPause(()=>{//监听暂停事件
    })
    this.setData({
      basePath: config.host+"/image",
      code: options.code
    });
    var that = this;
    console.log(options.code)
    console.log(options.openid)
    wx.request({
      url: config.word + 'getBatch',
      method: "POST",
      data: {
        userId: options.openid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data.data)
        that.setData({
          word: res.data.data
        })
        bindMusic(options.code, res.data.data.term)
      }
    })
    
    var a = setInterval(function () {
      //循环执行代码 
      if(loop)
      { 
        clearInterval(a);
        return;
      }
      wx.request({
        url: config.word + 'getBatch',
        method: "POST",
        data: {
          userId: options.openid
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
          console.log(res.data.data)
          var dd = res.data.data;
          if (null == dd) {
            loop = true;
          }
          that.setData({
            word: res.data.data
          })
          bindMusic(options.code, res.data.data.term)
        }
      })
    }, 3000) //循环时间 这里是1秒
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
    console.log("页面隐藏")
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log("页面卸载")
    loop = true
    innerAudioContext.stop();
    innerAudioContext.destroy();//销毁这个实例
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
export function bindMusic(grade, term) {
  innerAudioContext.stop();
  innerAudioContext.src = config.host+"/music/" + grade + "/" + term + ".mp3";
  innerAudioContext.play();
  // return innerAudioContext;
}