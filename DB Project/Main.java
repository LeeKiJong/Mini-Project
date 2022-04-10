package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import project.Inter.InterDao;
import project.Inter.InterDto;
import project.Inter.InterImpl;
import project.houseInfo.HouseInfoDaoImpl;
import project.houseInfo.HouseInfoDto;
import project.user.UserDao;
import project.user.UserDaoImpl;
import project.user.UserDto;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().menu();
	}
	

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 아이디로 검색");
			System.out.println("5. 모든 회원 정보 출력");
			System.out.println("6. 관심 지역 등록");
			System.out.println("7. 관심 지역 삭제");
			System.out.println("8. 관심 지역 조회");
			System.out.println("9. 동별 매매 실거래가 정보");
			System.out.println("10. 아파트별 매매 실거래가 정보");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : register();break;
				case 2 : update();break;
				case 3 : delete();break;
				case 4 : searchById();break;
				case 5 : searchAll();break;
				case 6 : InterRegister();break;
				case 7 : Interdelete();break;
				case 8 : IntersearchAll();break;
				case 9 : dongPhase(); break;
				case 10 : aptPhase(); break;
				
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	private void register() {
		try {
			System.out.println("--------------------- 회원 등록 ---------------------");
			System.out.print("회원 아이디 : ");
			String Id = in.readLine();
			System.out.print("회원 이름 : ");
			String Name = in.readLine();
			System.out.print("회원 전화번호 : ");
			String phone = in.readLine();
			System.out.print("회원 이메일 : ");
			String email = in.readLine();
			
			UserDto userDto = new UserDto();
			userDto.setId(Id);
			userDto.setName(Name);
			userDto.setPhone(phone);
			userDto.setEmail(email);
			
			UserDao userDao = UserDaoImpl.getUserDao();
			userDao.register(userDto);
			System.out.println("-------------------------------------------------");
			System.out.println("유저 등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void InterRegister() {
		
		try {
			System.out.println("--------------------- 관심 지역 등록 ---------------------");
			UserDto userDto = searchById();
			if(userDto==null) {
				System.out.println("해당 회원이 없습니다!!!!!");
			}
			else {
				String Id = userDto.getId();
				System.out.print("시 : ");
				String Si = in.readLine();
				System.out.print("구 : ");
				String Gu = in.readLine();
				System.out.print("동 : ");
				String Dong = in.readLine();
				
				InterDto interDto = new InterDto();
				interDto.setId(Id);
				interDto.setSi(Si);
				interDto.setGu(Gu);
				interDto.setDong(Dong);
				
				InterDao interDao = InterImpl.getInterDao();
				interDao.register(interDto);
				System.out.println("-------------------------------------------------");
				System.out.println("관심 지역 등록 성공!!!!!");
				System.out.println("-------------------------------------------------");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void update() {
		
		try {
			System.out.println("--------------------- 회원 정보 수정 ---------------------");
			UserDto userDto = searchById();
			if(userDto==null) {
				System.out.println("해당 회원이 없습니다!!!!!");
			}
			else {
				String Id = userDto.getId();
				System.out.print("수정할 회원 이름 : ");
				String Name = in.readLine();
				System.out.print("수정할 회원 전화번호 : ");
				String phone = in.readLine();
				System.out.print("수정할 회원 이메일 : ");
				String email = in.readLine();
				
				UserDaoImpl.getUserDao().update(Id, Name, phone, email);
				System.out.println("-------------------------------------------------");
				System.out.println("회원 정보 수정 성공!!!!!");
				System.out.println("-------------------------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete() {
		System.out.println("--------------------- 회원 삭제 ---------------------");
		UserDto userDto = searchById();
		if(userDto==null) {
			System.out.println("해당 회원이 없습니다!!!!!");
		}
		else {
			UserDaoImpl.getUserDao().delete(userDto.getId());
			System.out.println("-------------------------------------------------");
			System.out.println("회원 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		}
	}
	private void Interdelete() {
		System.out.println("--------------------- 관심 지역 삭제 ---------------------");
		UserDto userDto = searchById();
		if(userDto==null) {
			System.out.println("해당 회원이 없습니다!!!!!");
		}
		else {
			System.out.print("동 : ");
			String Dong = null;
			try {
				Dong = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InterImpl.getInterDao().delete(userDto.getId(), Dong);
			System.out.println("-------------------------------------------------");
			System.out.println("회원 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		}
	}
	private UserDto searchById() {
		UserDto userDto=null;
		try {
			System.out.print("회원 아이디 : ");
			String Id = in.readLine();
			userDto = UserDaoImpl.getUserDao().searchById(Id);
			showProduct(userDto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDto;
	}
	private void showProduct(UserDto userDto) {
		if(userDto != null) {
			System.out.println("============ 회원 정보 ============");
			System.out.println("회원 아이디 : " + userDto.getId());
			System.out.println("회원 이름 : " + userDto.getName());
			System.out.println("회원 전화번호 : " + userDto.getPhone());
			System.out.println("회원 이메일 : " + userDto.getEmail());
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("회원이 존재하지 않습니다.");
			System.out.println("-------------------------------------------------");
		}
	}
	private void searchAll() {
		List<UserDto> list = UserDaoImpl.getUserDao().searchAll();
		showList(list);
	}
	private void showList(List<UserDto> list) {
		System.out.println("===================================== 유저 목록 =====================================");
		System.out.println("유저아이디\t유저이름\t전화번호\t이메일");
		System.out.println("-------------------------------------------------------------------------------------");
		for(UserDto userDto : list) {
			System.out.println(userDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	private void IntersearchAll() {
		
		List<InterDto> list = InterImpl.getInterDao().searchAll();
		showInterList(list);
	}
	private void showInterList(List<InterDto> list) {
		System.out.println("===================================== 관심지역 목록 목록 =====================================");
		System.out.println("유저아이디\t시\t구\t동");
		System.out.println("-------------------------------------------------------------------------------------");
		for(InterDto interDto : list) {
			System.out.println(interDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	
	private void dongPhase() throws IOException {
		System.out.println("동 이름을 입력하세요");
		System.out.println(">>>");
		searhByDongName(in.readLine().trim());
	}
	
	private void aptPhase() throws IOException {
		System.out.println("아파트 이름을 입력하세요");
		System.out.println(">>>");
		searhByAptName(in.readLine().trim());
	}
	
	private void searhByDongName(String dongName) {
		List<HouseInfoDto> list = HouseInfoDaoImpl.getHouseInfoDao().searhByDongName(dongName);
		showHouseList(list);
	}
	
	private void searhByAptName(String aptName) {
		List<HouseInfoDto> list = HouseInfoDaoImpl.getHouseInfoDao().searhByAptName(aptName);
		showHouseList(list);
	}
	
	private void showHouseList(List<HouseInfoDto>  list) {
		for(HouseInfoDto houseInfoDto : list) {
			System.out.println(houseInfoDto);
		}
	}
}
