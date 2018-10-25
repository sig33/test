package com.internousdev.template3.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template3.dao.BuyItemDAO;
import com.internousdev.template3.dao.LoginDAO;
import com.internousdev.template3.dto.BuyItemDTO;
import com.internousdev.template3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//success→buyItem.jsp error→home.jsp
public class LoginAction extends ActionSupport implements SessionAware{
	
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object> session;
	
	//executeメソッド
	public String execute(){
		
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		
		result = ERROR;
		
		//loginDAOのgetLoginUserInfoメソッド
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		
		//入力値からユーザー情報の検索を行う
		//ログイン成功の場合次の画面で商品情報が必要なため商品情報を取得する
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			
			//セッションのMapにkeyとvalueを設定している
			//         (   " key "   ,   value   );
			//ログインIdとアイテムの情報３つ
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			
			return result;
		}
		
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	
}
