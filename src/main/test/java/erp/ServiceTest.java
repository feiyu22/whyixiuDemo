//package erp;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.whyixiu.erp.model.PurchasePlan;
//import com.whyixiu.erp.model.SysUser;
//import com.whyixiu.erp.model.vo.PurchaseVo;
//import com.whyixiu.erp.service.InvocingService;
//import com.whyixiu.erp.service.PurchaseService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring/spring-core.xml", "classpath:spring/spring-source.xml"})
//public class ServiceTest {
//	
//	@Resource
//	InvocingService invocingService;
//
//	@Resource 
//	PurchaseService purchaseService;
//	
//	@Test
//	public void test2(){
//		invocingService.getRemainTask();
//	}
//	
//	
//	@Test
//	public void test1(){
//		PurchaseVo vo = new PurchaseVo();
//		SysUser user = new SysUser();
//		user.setName("dafeiyu");
////		vo.setBeginDate("2016-12-10");
////		vo.setEndDate("2016-12-11");
//		List<PurchasePlan> list = purchaseService.getList(vo,user);
//		for (PurchasePlan purchasePlan : list) {
//			System.out.println(purchasePlan.getCompany());
//		}
//	}
//	
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//		String str = "2016-1-3";
//		String str2 = "2016-12-3";
//		Date date = new Date();
//		System.out.println(date.getMonth());
//		System.out.println(sdf.parse(str).getMonth());
//		System.out.println(sdf.parse(str2).getMonth());
//	}
//}
