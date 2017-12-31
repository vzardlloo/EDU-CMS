<div class="layui-body">
    <form class="layui-form"  style="padding: 15px">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px">
            <legend>发布课程</legend>
        </fieldset>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">课程编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="number" value=""  autocomplete="off" class="layui-input"  >
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">课程名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" value="" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">学分</label>
                <div class="layui-input-inline">
                    <select name="credit">
                        <option value="1.5">1.5</option>
                        <option value="2">2</option>
                        <option value="2.5">2.5</option>
                        <option value="3">3</option>
                        <option value="3.5">3.5</option>
                        <option value="4">4</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">课时</label>
                <div class="layui-input-inline">
                    <select name="period">
                        <option value="12周">12周</option>
                        <option value="16周">16周</option>
                        <option value="18周">18周</option>
                        <option value="20周">20周</option>

                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">上课教室</label>
                <div class="layui-input-inline">
                    <input type="text" value="" name="classroom"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">任课教师</label>
                <div class="layui-input-inline">
                    <input type="text" value="${teacher.getName()}" name="teacher"  autocomplete="off" class="layui-input" disabled="">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">上课时间</label>
                <div class="layui-input-inline" >
                    <select name="period" lay-verify="required" lay-search="">
                        <option value="">直接选择或搜索选择</option>
                        <option value="周一|一二节">周一|一二节</option>
                        <option value="周一|三四节">周一|三四节</option>
                        <option value="周一|五六节">周一|五六节</option>
                        <option value="周一|七八节">周一|七八节</option>
                        <option value="周一|晚上">周一|晚上</option>
                        <option value="周二|一二节">周二|一二节</option>
                        <option value="周二|三四节">周二|三四节</option>
                        <option value="周二|五六节">周二|五六节</option>
                        <option value="周二|七八节">周二|七八节</option>
                        <option value="周二|晚上">周二|晚上</option>
                        <option value="周三|一二节">周三|一二节</option>
                        <option value="周三|三四节">周三|三四节</option>
                        <option value="周三|五六节">周三|五六节</option>
                        <option value="周三|七八节">周三|七八节</option>
                        <option value="周三|晚上">周三|晚上</option>
                        <option value="周四|一二节">周四|一二节</option>
                        <option value="周四|三四节">周四|三四节</option>
                        <option value="周四|五六节">周四|五六节</option>
                        <option value="周四|七八节">周四|七八节</option>
                        <option value="周四|晚上">周四|晚上</option>
                        <option value="周五|一二节">周五|一二节</option>
                        <option value="周五|三四节">周五|三四节</option>
                        <option value="周五|五六节">周五|五六节</option>
                        <option value="周五|七八节">周五|七八节</option>
                        <option value="周五|晚上">周五|晚上</option>
                    </select>
                    </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">最大容量</label>
                <div class="layui-input-inline">
                    <input type="text" value="" name="maxChoosed"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>



        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"lay-submit="" lay-filter="course">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>