package com.liyc.springboot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyc
 * @since 2020-09-22
 */
public class Heros implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Float hpMax;

    private Float hpGrowth;

    private Float hpStart;

    private Float mpMax;

    private Float mpGrowth;

    private Float mpStart;

    private Float attackMax;

    private Float attackGrowth;

    private Float attackStart;

    private Float defenseMax;

    private Float defenseGrowth;

    private Float defenseStart;

    @TableField(value = "hp_5s_max")
    private Float hp5sMax;

    @TableField(value = "hp_5s_growth")
    private Float hp5sGrowth;

    @TableField(value = "hp_5s_start")
    private Float hp5sStart;

    @TableField(value = "mp_5s_max")
    private Float mp5sMax;

    @TableField(value = "mp_5s_growth")
    private Float mp5sGrowth;

    @TableField(value = "mp_5s_start")
    private Float mp5sStart;

    private Float attackSpeedMax;

    private String attackRange;

    private String roleMain;

    private String roleAssist;

    private LocalDate birthdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Float getHpMax() {
        return hpMax;
    }

    public void setHpMax(Float hpMax) {
        this.hpMax = hpMax;
    }
    public Float getHpGrowth() {
        return hpGrowth;
    }

    public void setHpGrowth(Float hpGrowth) {
        this.hpGrowth = hpGrowth;
    }
    public Float getHpStart() {
        return hpStart;
    }

    public void setHpStart(Float hpStart) {
        this.hpStart = hpStart;
    }
    public Float getMpMax() {
        return mpMax;
    }

    public void setMpMax(Float mpMax) {
        this.mpMax = mpMax;
    }
    public Float getMpGrowth() {
        return mpGrowth;
    }

    public void setMpGrowth(Float mpGrowth) {
        this.mpGrowth = mpGrowth;
    }
    public Float getMpStart() {
        return mpStart;
    }

    public void setMpStart(Float mpStart) {
        this.mpStart = mpStart;
    }
    public Float getAttackMax() {
        return attackMax;
    }

    public void setAttackMax(Float attackMax) {
        this.attackMax = attackMax;
    }
    public Float getAttackGrowth() {
        return attackGrowth;
    }

    public void setAttackGrowth(Float attackGrowth) {
        this.attackGrowth = attackGrowth;
    }
    public Float getAttackStart() {
        return attackStart;
    }

    public void setAttackStart(Float attackStart) {
        this.attackStart = attackStart;
    }
    public Float getDefenseMax() {
        return defenseMax;
    }

    public void setDefenseMax(Float defenseMax) {
        this.defenseMax = defenseMax;
    }
    public Float getDefenseGrowth() {
        return defenseGrowth;
    }

    public void setDefenseGrowth(Float defenseGrowth) {
        this.defenseGrowth = defenseGrowth;
    }
    public Float getDefenseStart() {
        return defenseStart;
    }

    public void setDefenseStart(Float defenseStart) {
        this.defenseStart = defenseStart;
    }
    public Float getHp5sMax() {
        return hp5sMax;
    }

    public void setHp5sMax(Float hp5sMax) {
        this.hp5sMax = hp5sMax;
    }
    public Float getHp5sGrowth() {
        return hp5sGrowth;
    }

    public void setHp5sGrowth(Float hp5sGrowth) {
        this.hp5sGrowth = hp5sGrowth;
    }
    public Float getHp5sStart() {
        return hp5sStart;
    }

    public void setHp5sStart(Float hp5sStart) {
        this.hp5sStart = hp5sStart;
    }
    public Float getMp5sMax() {
        return mp5sMax;
    }

    public void setMp5sMax(Float mp5sMax) {
        this.mp5sMax = mp5sMax;
    }
    public Float getMp5sGrowth() {
        return mp5sGrowth;
    }

    public void setMp5sGrowth(Float mp5sGrowth) {
        this.mp5sGrowth = mp5sGrowth;
    }
    public Float getMp5sStart() {
        return mp5sStart;
    }

    public void setMp5sStart(Float mp5sStart) {
        this.mp5sStart = mp5sStart;
    }
    public Float getAttackSpeedMax() {
        return attackSpeedMax;
    }

    public void setAttackSpeedMax(Float attackSpeedMax) {
        this.attackSpeedMax = attackSpeedMax;
    }
    public String getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(String attackRange) {
        this.attackRange = attackRange;
    }
    public String getRoleMain() {
        return roleMain;
    }

    public void setRoleMain(String roleMain) {
        this.roleMain = roleMain;
    }
    public String getRoleAssist() {
        return roleAssist;
    }

    public void setRoleAssist(String roleAssist) {
        this.roleAssist = roleAssist;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Heros{" +
            "id=" + id +
            ", name=" + name +
            ", hpMax=" + hpMax +
            ", hpGrowth=" + hpGrowth +
            ", hpStart=" + hpStart +
            ", mpMax=" + mpMax +
            ", mpGrowth=" + mpGrowth +
            ", mpStart=" + mpStart +
            ", attackMax=" + attackMax +
            ", attackGrowth=" + attackGrowth +
            ", attackStart=" + attackStart +
            ", defenseMax=" + defenseMax +
            ", defenseGrowth=" + defenseGrowth +
            ", defenseStart=" + defenseStart +
            ", hp5sMax=" + hp5sMax +
            ", hp5sGrowth=" + hp5sGrowth +
            ", hp5sStart=" + hp5sStart +
            ", mp5sMax=" + mp5sMax +
            ", mp5sGrowth=" + mp5sGrowth +
            ", mp5sStart=" + mp5sStart +
            ", attackSpeedMax=" + attackSpeedMax +
            ", attackRange=" + attackRange +
            ", roleMain=" + roleMain +
            ", roleAssist=" + roleAssist +
            ", birthdate=" + birthdate +
        "}";
    }
}
