var host = "https://dazhi123.top";
// var host = "http://localhost";
// var host = "http://192.168.2.120";

var config = {
  host,
  login_url:host+"/blog/activity",
  rotary_url:host+"/user",
  theme:host+"/blog/theme",
  tv_classification:host+"/blog/tv-classification/1/list",
  tv_tutorial:host+"/blog/tutorial-tv/",
  food:host+"/blog/food/randGetFood",//随机获取美食
  one_food:host+"/blog/food/randFood",//随机取一种食物
  food_base:host+"/blog/food",//根据id取值
  word_grade:host+"/blog/word-grade",//单词级别
  word:host+"/blog/word/"//单词
}

module.exports = config;