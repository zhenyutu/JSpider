package cn.tzy.app.lagou.entity;

import lombok.Getter;

import java.util.List;

/**
 * Created by tuzhenyu on 17-3-5.
 * @author tuzhenyu
 */
@Getter
public class PositionResult {
    private int pageSize;

    private List<Position> result;

}
