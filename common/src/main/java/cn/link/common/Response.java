package cn.link.common;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/26 22:51
 * @description 响应数据模型
 */
public class Response<T> {

    /**
     * 返回数据类型
     */
    private T data;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 状态
     */
    private Boolean success;

    /**
     * 默认响应成功 (构造私有化，只能调用 success、fail方法)
     */
    private Response() {
        message = "响应成功";
        data = null;
        success = true;
    }

    private Response(T data, Boolean success, String message) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    /**
     * 成功
     * @return
     */
    public static Response succeed() {
        return new Response();
    }

    public static <T> Response<T> succeed(T data) {
        return new Response<T>(data, true, "响应成功");
    }

    /**
     * 失败
     * @return
     */
    public static Response fail() {

        return new Response(null, false, "响应失败");

    }

    /**
     * 设置返回数据
     * @param data
     * @return
     */
    public Response<T> data(T data) {
        this.setData(data);
        return this;
    }

    /**
     * 设置返回信息
     * @param message
     * @return
     */
    public Response<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}
