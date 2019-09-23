export abstract class StringUtils {

    static isEmpty(value : string) : boolean {
        return value == null || value == undefined || value == '';
    }

}
