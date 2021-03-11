package com.rufeng.business.common;

import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.framework.redis.RedisCache;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.utils.IdUtils;
import com.rufeng.core.utils.VerifyCodeUtils;
import com.rufeng.core.utils.sign.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码操作处理
 *
 * @author ruoyi
 */
@RestController
public class CaptchaController {
    @Autowired
    private RedisCache redisCache;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public ResultData getCode(HttpServletResponse response) throws IOException {

        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 唯一标识
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        redisCache.setCacheObject(verifyKey, verifyCode, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 生成图片
        int w = 111, h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        try {
            ResultData data = ResultData.init();
            data.setData("uuid", uuid);
            data.setData("img", Base64.encode(stream.toByteArray()));
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(500, e.getMessage());
        } finally {
            stream.close();
        }
    }
}
