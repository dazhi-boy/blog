// pages/word/exclude/exclude.js
const config = require("../../../config");
var startX, endX;
var moveFlag = true;// 判断执行滑动事件

const innerAudioContext = wx.createInnerAudioContext()
innerAudioContext.autoplay = true


Page({

  /**
   * 页面的初始数据
   */
  data: {
    words: [],
    index: 0,
    showView: false,
    code: '',
    basePath: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      basePath: config.host+"/image"
    });
    var that = this;
    console.log(options.code)
    console.log(options.openid)
    wx.request({
      url: config.word + 'initAndGetWords',
      method: "POST",
      data: {
        grade: options.code,
        userId: options.openid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data.data)
        bindMusic(options.code, res.data.data[0].term)

        // innerAudioContext.src = config.host+"/music/" + options.code + "/" + res.data.data[0].term + ".mp3";
        that.setData({
          words: res.data.data,
          code: options.code
        })
      }
    })

    innerAudioContext.onPlay(() => {
      console.log('开始播放')
    })
    innerAudioContext.onError((res) => {
      console.log(res.errMsg)
      console.log(res.errCode)
    })
    innerAudioContext.play();
  },

  touchStart: function (e) {
    startX = e.touches[0].pageX; // 获取触摸时的原点
    moveFlag = true;
  },
  // 触摸移动事件
  touchMove: function (e) {
    endX = e.touches[0].pageX; // 获取触摸时的原点
    if (moveFlag) {
      if (endX - startX > 50) {
        console.log("move right");
        this.move2right();
        moveFlag = false;

        var word = this.data.words[this.data.index].term;

        bindMusic(this.data.code, word)

        // innerAudioContext.src = config.host+"/music/" + this.data.code + "/" + word + ".mp3";
        // innerAudioContext.onPlay(() => {
        //   console.log('开始播放')
        // })
        // innerAudioContext.onError((res) => {
        //   console.log(res.errMsg)
        //   console.log(res.errCode)
        // })
        // innerAudioContext.play();

      }
      if (startX - endX > 50) {
        console.log("move left");
        this.move2left();
        moveFlag = false;

        var word = this.data.words[this.data.index].term;

        bindMusic(this.data.code, word)

        // innerAudioContext.src = config.host+"/music/" + this.data.code + "/" + word + ".mp3";
        // innerAudioContext.onPlay(() => {
        //   console.log('开始播放')
        // })
        // innerAudioContext.onError((res) => {
        //   console.log(res.errMsg)
        //   console.log(res.errCode)
        // })
        // innerAudioContext.play();
      }
    }

  },
  // 触摸结束事件
  touchEnd: function (e) {
    moveFlag = true; // 回复滑动事件
    
  },

  move2left() {
    var that = this;
    var data = this.data.words[this.data.index];
    data.status = 1;
    // 请求后台，将该条记录状态改为已记住
    wx.request({
      url: config.word,
      method: 'PUT',
      data: data,
      headers: {
        'Content-Type': 'application/json'
      },
      success: function(result) {
        console.log(result)
      }
    })
    console.log(this.data.index)
    var ind = this.data.index+1;
    that.setData({
      content: "move2left",
      index: ind,
      showView: false
    });
  },
  move2right() {
    var that = this;
    var ind = this.data.index+1;
    that.setData({
      content: "move2right",
      index: ind,
      showView: false
    });
  },
  onChangeShowState: function () {
    this.setData({
      showView: true
    })
    console.log(innerAudioContext.src)
    innerAudioContext.stop();
    innerAudioContext.play();
    // this.setData({
    //   showView: (!this.data.showView)
    // })
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

export function bindMusic(grade, term) {
  innerAudioContext.src = config.host+"/music/" + grade + "/" + term + ".mp3";
  innerAudioContext.onPlay(() => {
    console.log('开始播放')
  })
  innerAudioContext.onError((res) => {
    console.log(res.errMsg)
    console.log(res.errCode)
  })
  innerAudioContext.play();
  // return innerAudioContext;
}