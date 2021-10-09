package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("Member")
public class MemberController {
    public final FetchMemberFlow fetchMemberFlow;
    public final CreateMemberFlow createMemberFlow;
    public final ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow, CreateMemberFlow createMemberFlow, ModifyMemberFlow modifyMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
        this.modifyMemberFlow = modifyMemberFlow;
    }

    //    @Autowired
//    public MemberController(FetchMemberFlow fetchMemberFlow,
//                            @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow, ModifyMemberFlow modifyMemberFlow) {
//        this.fetchMemberFlow = fetchMemberFlow;
//        this.createMemberFlow = createMemberFlow;
//        this.modifyMemberFlow = modifyMemberFlow;
//    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error",response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll(){
        List<MemberDto> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response =new GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Member.", notes = "Creating new Member in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Member was created successfully",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error",response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value ="Request to create a new Member.",
                    required = true)
            @RequestBody MemberDto member){
        MemberDto memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("{memberId}")
    @ApiOperation(value = "Fetches the specified Member.", notes = "Fetches the Member corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Found"),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getMember(
            @ApiParam(value = "The memberId that uniquely identifies the Member.",
                    example = "159",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId){

        MemberDto member = fetchMemberFlow.getMemberByMemberId(memberId);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{memberId}")
    @ApiOperation(value = "Deletes the specified Member.", notes = "Deletes the Member corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member deleted"),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> deleteMember(
            @ApiParam(value = "The memberId that uniquely identifies the Member.",
                    example = "159",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId){

        MemberDto memberr = modifyMemberFlow.deleteMember(memberId);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberr);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{memberId}")
    @ApiOperation(value = "Updates the specified Member.", notes = "Updates the Member corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Updated"),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> updateMember(
            @ApiParam(value = "The memberId that uniquely identifies the Member.",
                    example = "159",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId,

            @ApiParam(value = "The new Miles of a specific member ",
                    name = "milesAmount",
                    required = true)
            @RequestParam("milesAmount") final Long milesAmount,

            @ApiParam(value = "The optional new date with which to update the Member start date is ISO date format (yyyy-MM-dd)\r\n",
                    name = "memberStartDate",
                    required = true)
            @RequestParam(value = "memberStartDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate memberStartDate
    ){

        MemberDto member = modifyMemberFlow.updateMember(memberId, milesAmount, memberStartDate);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
