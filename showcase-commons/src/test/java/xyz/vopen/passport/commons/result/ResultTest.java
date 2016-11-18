package xyz.vopen.passport.commons.result;

import com.google.common.collect.Maps;
import org.junit.Test;
import xyz.vopen.passport.PassportCode;
import xyz.vopen.passport.commons.Result;

import java.util.Map;

/**
 * Result test
 * Created by ive on 08/11/2016.
 */
public class ResultTest {


    @SuppressWarnings("rawtypes")
    @Test
    public void testResult () {

        Map<String, String> data = Maps.newHashMap();
        data.put("1111", "aasdada");
        data.put("ssss", "aasdada");
        data.put("eddd", "aasdada");

        Result result = Result.newBuilder().result(PassportCode.SUCCESS).data(data).build();

        Result.newBuilder().result(PassportCode.SUCCESS, data).build();

        System.out.println(result.toString());
        System.out.println(result.toJson());

    }


}
