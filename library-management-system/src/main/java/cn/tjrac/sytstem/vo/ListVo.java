package cn.tjrac.sytstem.vo;

import java.util.List;

public class ListVo {

    private List<DepartVo> departmentVoList;
    private List<ProfessionVo> professionVoList;
    private List<GradeVo> gradeVoList;

    public List<DepartVo> getDepartmentVoList() {
        return departmentVoList;
    }

    public void setDepartmentVoList(List<DepartVo> departmentVoList) {
        this.departmentVoList = departmentVoList;
    }

    public List<ProfessionVo> getProfessionVoList() {
        return professionVoList;
    }

    public void setProfessionVoList(List<ProfessionVo> professionVoList) {
        this.professionVoList = professionVoList;
    }

    public List<GradeVo> getGradeVoList() {
        return gradeVoList;
    }

    public void setGradeVoList(List<GradeVo> gradeVoList) {
        this.gradeVoList = gradeVoList;
    }
}
