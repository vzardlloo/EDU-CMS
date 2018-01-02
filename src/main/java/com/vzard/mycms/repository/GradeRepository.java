package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IGrade;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.error.ErrorException;
import com.vzard.mycms.model.dto.StudentWithGrade;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static com.vzard.mycms.database.Tables.GRADE;

@Service
public class GradeRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public IGrade getGradeById(Long id){
        if (null == id){
            throw new ErrorException("param error",500);
        }
        return dsl.select()
                .from(GRADE)
                .where(GRADE.ID.eq(id))
                .fetchOneInto(IGrade.class);
    }

    public IGrade getGrageByUniqueKey(String studentNum,String courseNum){
        if (null == studentNum || null == courseNum){
            throw new ErrorException("param error",500);
        }
        IGrade iGrade = dsl.select()
                .from(GRADE)
                .where(GRADE.STUDENT_NUM.eq(studentNum)
                        .and(GRADE.COURSE_NUM.eq(courseNum)))
                .fetchOneInto(IGrade.class);
        return iGrade;
    }

    public List<IGrade> getGradeList(String courseNum){

        return dsl.select()
                .from(GRADE)
                .where(Tables.GRADE.COURSE_NUM.eq(courseNum))
                .fetchInto(IGrade.class);
    }


    public IGrade addGradeInfo(Grade grade){
        if (null == grade){
            throw new ErrorException("param error",500);
        }else if (isGradeExist(grade.getStudentNum(),grade.getCourseNum())){
            throw new ErrorException("already exist",500);
        }

        dsl.insertInto(GRADE)
                .columns(GRADE.STUDENT_NUM,GRADE.COURSE_NUM,GRADE.PAPER_GRADE,
                        GRADE.PACIFIC_GRADE,GRADE.OVERALL_GRADE,GRADE.CREATED_AT,GRADE.UPDATED_AT)
                .values(grade.getStudentNum(),grade.getCourseNum(),grade.getPaperGrade(),
                        grade.getPacificGrade(),grade.getOverallGrade(),new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis())).execute();

        IGrade iGrade = getGrageByUniqueKey(grade.getStudentNum(),grade.getCourseNum());
        if (null == iGrade){
            throw new ErrorException("insert error",500);
        }

        return iGrade;
    }

    public IGrade updateGradeInfo(StudentWithGrade grade){
        if (null == grade){
            throw new ErrorException("param error",500);
        }else if (!isGradeExist(grade.getNumber(),grade.getCourseNum())){
            throw new ErrorException("not exist",500);
        }

        dsl.update(GRADE)
                .set(GRADE.PAPER_GRADE,grade.getPaperGrade())
                .set(GRADE.PACIFIC_GRADE,grade.getPacificGrade())
                .set(GRADE.OVERALL_GRADE,grade.getOverallGrade())
                .set(GRADE.UPDATED_AT,new Timestamp(System.currentTimeMillis()))
                .where(GRADE.STUDENT_NUM.eq(grade.getNumber()))
                .and(GRADE.COURSE_NUM.eq(grade.getCourseNum()))
                .execute();

        return getGrageByUniqueKey(grade.getNumber(),grade.getCourseNum());

    }

    public void deleteGradeInfo(Long id){
        if (null == id){
            throw new ErrorException("param error",500);
        }else if (!isGradeExist(id)){
            throw new ErrorException("not exist",500);
        }

        dsl.delete(GRADE)
                .where(GRADE.ID.eq(id))
                .execute();
        if (isGradeExist(id)){
            throw new ErrorException("delete error",500);
        }
    }



    //=======util========

    private Boolean isGradeExist(Long id){
        if (null != getGradeById(id)){
            return true;
        }
        return false;
    }

    private Boolean isGradeExist(String studentNum,String courseNum){
        IGrade iGrade = getGrageByUniqueKey(studentNum,courseNum);
        if (null != iGrade){
            return true;
        }

        return false;
    }


}
