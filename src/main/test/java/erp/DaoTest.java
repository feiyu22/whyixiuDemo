//package erp;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.whyixiu.erp.dao.InvoicingMapper;
//import com.whyixiu.erp.dao.ProductMapper;
//import com.whyixiu.erp.dao.PurchasePlanMapper;
//import com.whyixiu.erp.model.Invoicing;
//import com.whyixiu.erp.model.Product;
//import com.whyixiu.erp.model.PurchasePlan;
//import com.whyixiu.erp.model.vo.InvoicingVo;
//import com.whyixiu.erp.model.vo.PurchaseVo;
//import com.whyixiu.erp.service.PurchaseService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring/spring-core.xml", "classpath:spring/spring-source.xml"})
//public class DaoTest {
//
//	@Resource
//	PurchasePlanMapper purchasePlanMapper;
//	
//	@Resource
//	ProductMapper productMapper;
//	
//	@Resource
//	InvoicingMapper invoicingMapper;
//	
//	
//	@Test
//	public void test3(){
//		InvoicingVo vo = new InvoicingVo();
//		vo.getInvoicing().setUserId(1);
//		List<Invoicing> list = invoicingMapper.selectByUser(vo);
//		for (Invoicing in : list) {
//			System.out.println(in.getCompany());
//		}
//	}
//	
//	@Test
//	public void test1(){
//		List<Product> list = productMapper.selectByUser("dafeiyu");
//		for (Product product : list) {
//			System.out.println(product.getName());
//		}
//	}
//	
//	@Test
//	public void test2(){
//		PurchaseVo vo = new PurchaseVo();
//		vo.getPurchasePlan().setCreateBy("dafeiyu");
//		List<PurchasePlan> list = purchasePlanMapper.selectByUser(vo);
//		for (PurchasePlan purchaseVo : list) {
//			System.out.println(purchaseVo.getCompany());
//		}
//	}
//	
//	
//}
