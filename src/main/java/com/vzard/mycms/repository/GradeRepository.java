package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IGrade;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Timestamp;
import java.util.List;

import static com.vzard.mycms.database.Tables.GRADE;

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

    public IGrade getGrageByUniqueKey(Long studentNum,Long courseNum){
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

    public List<IGrade> getGradeList(Long courseNum){

        return dsl.select()
                .from(GRADE)
                .where(Tables.GRADE.ID.eq(courseNum))
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

    public IGrade updateGradeInfo(Grade grade){
        if (null == grade){
            throw new ErrorException("param error",500);
        }else if (!isGradeExist(grade.getStudentNum(),grade.getCourseNum())){
            throw new ErrorException("not exist",500);
        }

        dsl.update(GRADE)
                .set(GRADE.STUDENT_NUM,grade.getStudentNum())
                .set(GRADE.COURSE_NUM,grade.getCourseNum())
                .set(GRADE.PAPER_GRADE,grade.getPaperGrade())
                .set(GRADE.PACIFIC_GRADE,grade.getPacificGrade())
                .set(GRADE.OVERALL_GRADE,grade.getOverallGrade())
                .set(GRADE.UPDATED_AT,new Timestamp(System.currentTimeMillis()))
                .execute();

        return getGrageByUniqueKey(grade.getStudentNum(),grade.getCourseNum());

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

    private Boolean isGradeExist(Long studentNum,Long courseNum){
        IGrade iGrade = getGrageByUniqueKey(studentNum,courseNum);
        if (null != iGrade){
            return true;
        }

        return false;
    }


}
