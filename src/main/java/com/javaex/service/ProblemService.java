package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.ProblemDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.ProblemVo;

@Service
public class ProblemService {

	@Autowired
	private ProblemDao proDao;

	// 카테고리
	public List<CategoryVo> getCategory(int userNo) {
		System.out.println("CateService- getCategory");

		return proDao.selectCategory(userNo);
	}

	// 메인폴더
	public int addMainFolder(CategoryVo cateVo) {
		System.out.println("CateService- getcateVo");
		return proDao.addMainFolder(cateVo);
	}

	// 서브폴더
	public int addSubFolder(CategoryVo cateVo) {
		System.out.println("CateService- addSubFolder()");
		return proDao.addSubFolder(cateVo);
	}

	// 폴더 수정
	public int updateFolder(CategoryVo cateVo) {
		System.out.println("CateService- updateFolder()");

		return proDao.updateFolder(cateVo);
	}

	// 문제 리스트
	public List<ProblemVo> getProblem(int cateNo) {
		System.out.println("ProblemService- getProblem");

		return proDao.selectProblem(cateNo);
	}

	// 문제 작성
	public int ProblemInsert(MultipartFile file, ProblemVo proVo, String choice, Map<String, Object> map) {
		System.out.println("ProblemService- problemInsert");
		System.out.println("파일이름" + file.getOriginalFilename());
		String saveDir = "";
		String exName;
		String saveName;
		String filePath;

		if (proVo.getContentImage() != null) {

			// db저장할 정보 수집
			saveDir = "C:\\javaStudy\\upload";

			exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			filePath = saveDir + "\\" + saveName;

			proVo.setContentImage(saveName);
			try {
				byte[] fileData = file.getBytes();
				OutputStream out = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(out);

				bos.write(fileData);
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("service" + proVo);
		proDao.ProblemInsert(proVo);

		String[] arr = choice.split(",");
		System.out.println(choice.length());
		for (int i = 1; i <= 4; i++) {

			if (choice.length() > 3) {

				filePath = "";
				proDao.ChoiceInsert(filePath, arr[i - 1], proVo.getProblemNo(), i);
			} else {
				file = (MultipartFile) map.get("file" + i);
				exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

				saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

				filePath = saveDir + "\\" + saveName;

				proVo.setContentImage(saveName);

				try {
					byte[] fileData = file.getBytes();
					OutputStream out = new FileOutputStream(filePath);
					BufferedOutputStream bos = new BufferedOutputStream(out);

					bos.write(fileData);
					bos.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			proDao.ChoiceInsert(filePath, "", proVo.getProblemNo(), i);
		}

		return 1;
	}

	// 문제 보기
	public ProblemVo view(int proNo) {
		System.out.println("ProblemService- view");

		return proDao.problemView(proNo);
	}

	// 문제 수정
	public int modify(MultipartFile file, ProblemVo proVo, Map<String, Object> map) {
		System.out.println("ProblemService- modify");
		System.out.println("파일이름" + file.getOriginalFilename());

		// db저장할 정보 수집
		String saveDir = "C:\\javaStudy\\upload";

		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		String filePath = saveDir + "\\" + saveName;

		proVo.setContentImage(saveName);

		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(out);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("service" + proVo);
		proDao.ProblemModify(proVo);
		for (int i = 1; i <= 4; i++) {

			file = (MultipartFile) map.get("file" + i);
			exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			filePath = saveDir + "\\" + saveName;

			proVo.setContentImage(saveName);

			try {
				byte[] fileData = file.getBytes();
				OutputStream out = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(out);

				bos.write(fileData);
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			proDao.ChoiceModify(filePath, proVo.getProblemNo(), i);
		}

		return 1;
	}
}
