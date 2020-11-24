package gr.uom.myfirstrestapp;

import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private static final String TAG="JsonParser";

    private static final String USER_ID_LITERAL = "userId";
    private static final String POST_ID_LITERAL = "id";
    private static final String TITLE_LITERAL = "title";
    private static final String BODY_LITERAL = "body";

    public List<Post> parsePostData(String postJsonData){
        List<Post> postList = new ArrayList<>();
        try{
            JSONArray jsonPostArray = new JSONArray(postJsonData);
            for(int i=0;i<jsonPostArray.length();i++){
                JSONObject postJsonObject = jsonPostArray.getJSONObject(i);
                int userId = postJsonObject.getInt(USER_ID_LITERAL);
                int postId = postJsonObject.getInt(POST_ID_LITERAL);
                String title = postJsonObject.getString(TITLE_LITERAL);
                String body = postJsonObject.getString(BODY_LITERAL);

                Post post = new Post();
                post.setPostId(postId);
                post.setUserId(userId);
                post.setPostTitle(title);
                post.setPostBody(body);

                postList.add(post);
            }
        }
        catch(Exception e){
            Log.e(TAG,"Error happened!",e);
        }
        return postList;
    }
}
