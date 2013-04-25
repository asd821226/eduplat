package com.yinzhi.eduplat.service.reading;

import java.util.Date;
import java.util.List;

import org.exitsoft.orm.core.spring.data.jpa.specification.Specifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.dao.finance.BookDao;
import com.yinzhi.eduplat.dao.reading.BokcateDao;
import com.yinzhi.eduplat.dao.reading.BoknoteDao;
import com.yinzhi.eduplat.dao.reading.BokreplayDao;
import com.yinzhi.eduplat.dao.reading.BokstarDao;
import com.yinzhi.eduplat.dao.reading.CommentDao;
import com.yinzhi.eduplat.dao.reading.FavoriteDao;
import com.yinzhi.eduplat.dao.reading.RecommendDao;
import com.yinzhi.eduplat.entity.finance.Book;
import com.yinzhi.eduplat.entity.reading.Bokcate;
import com.yinzhi.eduplat.entity.reading.Boknote;
import com.yinzhi.eduplat.entity.reading.Bokreplay;
import com.yinzhi.eduplat.entity.reading.Bokstar;
import com.yinzhi.eduplat.entity.reading.Comment;
import com.yinzhi.eduplat.entity.reading.Favorite;
import com.yinzhi.eduplat.entity.reading.Recommend;

@Service
@Transactional
public class ReadingManager implements EduplatContextConstant{

	private final static Logger logger = LoggerFactory.getLogger(ReadingManager.class);
	
	// 标签数据访问
	@Autowired
	private BokcateDao bokcateDao;
	// 笔记数据访问
	@Autowired
	private BoknoteDao boknoteDao;
	// 回应数据访问
	@Autowired
	private BokreplayDao bokreplayDao;
	// 评分数据访问
	@Autowired
	private BokstarDao bokstarDao;
	// 书评数据访问
	@Autowired
	private CommentDao commentDao;
	// 收藏数据访问
	@Autowired
	private FavoriteDao favoriteDao;
	// 推荐数据访问
	@Autowired
	private RecommendDao recommendDao;
	// 图书数据访问
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 新书快递，分页
	 * @param pageable
	 * @return
	 */
	public List<Book> getNewboks(Pageable pageable){
		return bookDao.getNewboks(pageable).getContent();
	}
	
	/**
	 * 最受关注图书榜（收藏），分页
	 * @return
	 */
	public List<Book> getTopfav(){
		
		return null;
	}
	
	/**
	 * 热门标签
	 * @return
	 */
	public List<Bokcate> getTopCate(){
		
		return null;
	}
	
	/**
	 * 搜索图书，分页
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	public Page<Book> bokSearch(String keyword, Pageable pageable) {
		return bookDao.search(keyword, pageable);
	}
	
	/**
	 * 查看图书详细
	 * @param bokId
	 * @return
	 */
	public Book bokinfo(String bokId){
		return bookDao.findOne(bokId);
	}
	
	/**
	 * 获取图书评分
	 * @param bokId
	 * @return
	 */
	public Bokstar bokstar(String bokId){
		return bokstarDao.findOne(Specifications.get("fkBookId", bokId));
	}
	
	/**
	 * 获取图书赞的数目
	 * @param bokId
	 * @return
	 */
	public long totalRem(String bokId){
		return bokstarDao.count(Specifications.get("fkBookId", bokId));
	}
	
	/**
	 * 获取图书书评，分页
	 * @param bokId
	 * @param pageable
	 * @return
	 */
	public Page<Comment> bokcmt(String bokId, Pageable pageable) {
		return commentDao.findAll(Specifications.get("fkBookId", bokId), pageable);
	}
	
	/**
	 * 获取图书笔记，分页
	 * @param bokId
	 * @param pageable
	 * @return
	 */
	public Page<Boknote> boknte(String bokId, Pageable pageable) {
		return boknoteDao.findAll(Specifications.get("fkBookId", bokId), pageable);
	}
	
	/**
	 * 收藏
	 * @param usrId
	 * @param bokId
	 * @return
	 */
	public Favorite createFav(String usrId, String bokId){
		Favorite fav = new Favorite();
		fav.setFkUserId(usrId);
		fav.setFkBookId(bokId);
		fav.setCreateTime(new Date());
		return favoriteDao.save(fav);
	}
	
	/**
	 * 推荐/赞
	 * @param usrId
	 * @param bokId
	 * @param content 允许为空
	 * @return
	 */
	public Recommend createRem(String usrId, String bokId, String content){
		Recommend rem = new Recommend();
		rem.setFkUserId(usrId);
		rem.setFkBookId(bokId);
		rem.setCreateTime(new Date());
		if(content!=null)
			rem.setContent(content);
		return recommendDao.save(rem);
	}
	/**
	 * 查找书评内容
	 * @param cmtId 书评ID
	 * @return
	 */
	public Comment getComment(String cmtId){
		return commentDao.findOne(cmtId);
	}
	
	/**
	 * 保存书评内容
	 * @param usrId
	 * @param bokId
	 * @param content
	 * @return
	 */
	public Comment createCmt(String usrId, String bokId,String title, String content){
		Comment cmt = new Comment();
		cmt.setTitle(title);
		cmt.setContent(content);
		cmt.setCmtStatus(CMT_STATUS_1);// 暂时默认状态为【已审核】
		cmt.setFkUserId(usrId);
		cmt.setFkBookId(bokId);
		cmt.setCreateTime(new Date());
		return commentDao.save(cmt);
	}
	
	/**
	 * 查找笔记内容
	 * @param nteId
	 * @return
	 */
	public Boknote getBoknote(String nteId){
		return boknoteDao.findOne(nteId);
	}
	
	/**
	 * 保存笔记内容
	 * @param usrId
	 * @param bokId
	 * @param content
	 * @param chpName
	 * @param pageNo
	 * @return
	 */
	public Boknote createNte(String usrId, String bokId, String content, String chpName, Integer pageNo){
		Boknote nte = new Boknote();
		nte.setContent(content);
		nte.setChpName(chpName);
		nte.setPageNo(pageNo);
		nte.setFkUserId(usrId);
		nte.setFkBookId(bokId);
		nte.setNteStatus(NTE_STATUS_1);// 暂时默认状态为【已审核】
		nte.setCreateTime(new Date());
		return boknoteDao.save(nte);
	}
	
	/**
	 * 获取书评的回应
	 * @param cmtId
	 * @param pageable
	 * @return
	 */
	public Page<Bokreplay> bokrep(String cmtId, Pageable pageable) {
		return bokreplayDao.findAll(Specifications.get("fkCommentId", cmtId), pageable);
	}
	
	/**
	 * 保存回应内容
	 * @param usrId
	 * @param cmtId
	 * @param content
	 * @return
	 */
	public Bokreplay createRep(String usrId, String cmtId, String content){
		Bokreplay rep = new Bokreplay();
		rep.setFkUserId(usrId);
		rep.setFkCommentId(cmtId);
		rep.setContent(content);
		rep.setRepStatus(REP_STATUS_1);// 暂时默认状态为【已审核】
		rep.setCreateTime(new Date());
		return bokreplayDao.save(rep);
	}
	/**
	 * 我的收藏，分页
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Favorite> myfav(String usrId, Pageable pageable) {
		return favoriteDao.findAll(Specifications.get("fkUserId", usrId), pageable);
	}
	
	/**
	 * 我的笔记，分页
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Boknote> mynte(String usrId, Pageable pageable) {
		return boknoteDao.findAll(Specifications.get("fkUserId", usrId), pageable);
	}
	
	/**
	 * 我的书评，分页
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Comment> mycmt(String usrId, Pageable pageable) {
		return commentDao.findAll(Specifications.get("fkUserId", usrId), pageable);
	}
	
	/**
	 * 我的回应，分页
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Bokreplay> myrep(String usrId, Pageable pageable) {
		return bokreplayDao.findAll(Specifications.get("fkUserId", usrId), pageable);
	}
	
	/**
	 * 删除收藏
	 * @param favId
	 */
	public void deleteFav(String favId){
		favoriteDao.delete(favId);
	}
	
	/**
	 * 更新笔记状态【已审核/已删除】
	 * @param nteId
	 * @param nteStatus
	 */
	public void updateNteStatus(String nteId, Integer nteStatus){
		Boknote nte = new Boknote();
		nte.setId(nteId);
		nte.setNteStatus(nteStatus);
		boknoteDao.save(nte);
	}
	
	/**
	 * 更新书评状态【已审核/已删除】
	 * @param cmtId
	 * @param cmtStatus
	 */
	public void updateCmtStatus(String cmtId, Integer cmtStatus){
		Comment cmt = new Comment();
		cmt.setId(cmtId);
		cmt.setCmtStatus(cmtStatus);
		commentDao.save(cmt);
	}
	
	/**
	 * 更新回应状态【已审核/已删除】
	 * @param repId
	 * @param repStatus
	 */
	public void updateRepStatus(String repId, Integer repStatus){
		Bokreplay rep = new Bokreplay();
		rep.setId(repId);
		rep.setRepStatus(repStatus);
		bokreplayDao.save(rep);
	}
	/**
	 * 获取图书评分信息
	 * @param starId
	 * @return
	 */
	public Bokstar getBokstar(String starId){
		return bokstarDao.findOne(starId);
	}
	/**
	 * 更新/保存图书评分信息
	 * @param entity
	 * @return
	 */
	public Bokstar saveBokstar(Bokstar entity){
		return bokstarDao.save(entity);
	}
}
