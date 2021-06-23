package com.dazhi.blogprovider.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.blogprovider.blog.entity.Word;
import com.dazhi.blogprovider.blog.service.IWordService;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 单词表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@RestController
@CrossOrigin
@RequestMapping("blog/word")
@Api(value = "blog/word", tags = "WordController", description = "单词管理接口")
public class WordController extends BaseController<Word, IWordService> {

    @GetMapping("/init")
    @ApiOperation(value = "初始化")
    public Result init() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.init();
        return Result.ok("初始化成功");
    }

    @GetMapping("/initTranslate")
    @ApiOperation(value = "初始化翻译")
    public Result initTranslate() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initTranslate();
        return Result.ok("翻译成功");
    }

    @GetMapping("/initMusic")
    @ApiOperation(value = "初始化读音")
    public Result initMusic() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initMusic();
        return Result.ok("初始化读音");
    }

    @GetMapping("/initTree/{grade}/{userId}")
    @ApiOperation(value = "初始化单词树")
    public Result initTree(@PathVariable("grade") String grade, @PathVariable("userId") String userId) throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initTree(grade, userId);
        return Result.ok("初始化单词树");
    }

    @GetMapping("/getBatch/{userId}")
    @ApiOperation(value = "获取一批单词")
    public Result<Word> getBatch(@PathVariable("userId") String userId) throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        Word word = iWordService.getBatch(userId);

//        IPage<Word> page = new Page<>(1, 5);
//
//        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
//
//        CoreCache.wordFrequencyCache.get("1");
//        queryWrapper.eq("frequency", "");
//        IPage<Word> tPage = iWordService.page(page, queryWrapper);

        Result<Word> result = Result.ok("OK");
        result.setData(word);
        return result;
    }

    @GetMapping("/initWord/{grade}/{userId}")
    @ApiOperation(value = "初始化自己需要记的所有的单词")
    public Result<List<Word>> initWord(@PathVariable("grade") String grade, @PathVariable("userId") String userId) {
        String sql = "INSERT INTo word (version,term,translate,`grade`,user_id) " +
                "(SELECT version,term,translate,`grade`,'"+userId+"' FROM word WHERE grade = '"+grade+"' and user_id is null)";
        /*QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("grade",grade).isNull("user_id");
        IWordService iWordService = (IWordService) super.iService;
        List<Word> wordList = iWordService.list(queryWrapper);
        for (Word word : wordList) {
            word.setId(null);
            word.setUserId(userId);
        }
        iWordService.saveBatch(wordList);*/
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initWord(grade,userId);
        return Result.ok("搞定");
    }

    @PostMapping("/initAndGetWords")
    @ApiOperation(value = "获取没记住的所有的单词")
    public Result<List<Word>> initAndGetWords(@RequestBody Map<String, Object> data) {
        System.out.println(data.get("grade")+"-----"+data.get("userId"));
        IWordService iWordService = (IWordService) super.iService;
        List<Word> wordList = iWordService.initAndGetWords(data.get("grade").toString(),data.get("userId").toString());
        Result<List<Word>> result = Result.ok("OK");
        result.setData(wordList);
        return result;
    }

    @GetMapping("/getWordsByGrade/{grade}/{userId}")
    @ApiOperation(value = "获取没记住的所有的单词")
    public Result<List<Word>> getWordsByGrade(@PathVariable("grade") String grade, @PathVariable("userId") Long userId) {
        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("grade",grade).eq("user_id",userId).isNull("status");
        IWordService iWordService = (IWordService) super.iService;
        List<Word> wordList = iWordService.list(queryWrapper);
        Result<List<Word>> result = Result.ok("OK");
        result.setData(wordList);
        return result;
    }

    @GetMapping("/count/{grade}/{userId}")
    @ApiOperation(value = "获取没记住的所有的单词")
    public Result<String> count(@PathVariable("grade") String grade, @PathVariable("userId") Long userId) {
        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("grade",grade).eq("user_id",userId).isNull("status");
        IWordService iWordService = (IWordService) super.iService;
        int unremember = iWordService.count(queryWrapper);
        QueryWrapper<Word> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("grade",grade).eq("user_id",userId).eq("status","1");
        int remember = iWordService.count(queryWrapper1);
        Result<String> result = Result.ok("OK");
        result.setData("未记住："+unremember+ " -- 已记住："+ remember);
        return result;
    }

    public static void main(String[] args) {
        int frequency = 1;

        int group = 1;
        for (int j = 0; j<2; j++) {
            group += j;
            for (int i = 0; i < 2; i++) {
                System.out.println(group);
            }
        }
    }
}
